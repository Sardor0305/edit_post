package org.example.bot.databse;

import org.example.bot.entitiy.BotDataEntity;
import org.example.bot.utiliy.LinkSave;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExecuteData {

    public static void createTableIfNotExist() {
        final Connection connections = DatabaseConnection.getConnections();
        try (PreparedStatement statement = connections.prepareStatement("""
                     CREATE TABLE IF NOT EXISTS bot_data (
                                chat_id BIGINT PRIMARY KEY,
                                url VARCHAR(512),
                                state VARCHAR(128)
                            );
                """)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating table", e);
        }
    }

    public static void createChat(final long chat_id, final String url, final String state) {
        final var botData = new BotDataEntity(chat_id, url, state);
        LinkSave.SAVE_LINK_MAP.put(chat_id, botData);
        final Connection connections = DatabaseConnection.getConnections();
        try (PreparedStatement statement = connections.prepareStatement("""
                INSERT INTO bot_data (chat_id, url, state) 
                VALUES (?, ?, ?)
                """)) {
            statement.setLong(1, chat_id);
            statement.setString(2, url);
            statement.setString(3, state);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting data into bot_data", e);
        }
    }

    public static void updateChatState(final long chat_id, final String newState) {
        final var botDataEntity = fetchChat(chat_id);
        botDataEntity.setState(newState);
        LinkSave.SAVE_LINK_MAP.put(chat_id, botDataEntity);
        final Connection connections = DatabaseConnection.getConnections();
        try (final PreparedStatement statement = connections.prepareStatement("""
                UPDATE bot_data 
                SET state = ? 
                WHERE chat_id = ?
                """)) {
            statement.setString(1, newState);
            statement.setLong(2, chat_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating state in bot_data", e);
        }
    }

    public static void updateChatUrl(final long chat_id, final String url) {
        final var botDataEntity = fetchChat(chat_id);
        botDataEntity.setUrl(url);
        LinkSave.SAVE_LINK_MAP.put(chat_id, botDataEntity);
        final Connection connections = DatabaseConnection.getConnections();
        try (PreparedStatement statement = connections.prepareStatement("""
                UPDATE bot_data 
                SET url = ? 
                WHERE chat_id = ?
                """)) {
            statement.setString(1, url);
            statement.setLong(2, chat_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating url in bot_data", e);
        }
    }

    public static void updateChat(long chat_id, String url, final String state) {
        final var botDataEntity = fetchChat(chat_id);
        botDataEntity.setUrl(url);
        botDataEntity.setState(state);
        LinkSave.SAVE_LINK_MAP.put(chat_id, botDataEntity);
        final Connection connections = DatabaseConnection.getConnections();
        try (final PreparedStatement statement = connections.prepareStatement("""
                UPDATE bot_data 
                SET url = ?, state = ?
                WHERE chat_id = ?
                """)) {
            statement.setString(1, url);
            statement.setString(2, state);
            statement.setLong(3, chat_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating chat in bot_data", e);
        }
    }


    public static void deleteChat(final long chat_id) {
        LinkSave.SAVE_LINK_MAP.remove(chat_id);
        final Connection connections = DatabaseConnection.getConnections();
        try (final PreparedStatement statement = connections.prepareStatement("""
                DELETE FROM bot_data 
                WHERE chat_id = ?
                """)) {
            statement.setLong(1, chat_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting data from bot_data", e);
        }
    }

    public static BotDataEntity fetchChat(final long chat_id) {
        if (LinkSave.SAVE_LINK_MAP.containsKey(chat_id)) {
            return LinkSave.SAVE_LINK_MAP.get(chat_id);
        }
        final Connection connections = DatabaseConnection.getConnections();
        try (final PreparedStatement statement = connections.prepareStatement("""
                SELECT * FROM bot_data 
                WHERE chat_id = ?
                """)) {
            statement.setLong(1, chat_id);
            final var resultSet = statement.executeQuery();
            final var botData = new BotDataEntity();
            while (resultSet.next()) {
                botData.setChatId(resultSet.getLong("chat_id"));
                botData.setUrl(resultSet.getString("url"));
                botData.setState(resultSet.getString("state"));
            }
            if (botData.getChatId() != null) {
                LinkSave.SAVE_LINK_MAP.put(chat_id, botData);
            }
            return botData;
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching data from bot_data", e);
        }
    }
}
