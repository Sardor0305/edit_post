package org.example.bot.entitiy;

public class BotDataEntity {

    private Long chatId;
    private String url;
    private String state;


    public BotDataEntity(Long chatId, String url, String state) {
        this.chatId = chatId;
        this.url = url;
        this.state = state;
    }

    public BotDataEntity() {
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
