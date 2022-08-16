package org.telegram.chatbot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

public class Controller {

    String[] commandsCapital = {"Выебать", "Трахнуть", "Изнасиловать", "Делать секс", "Разорвать очко", "Порвать пизду",
            "Дать в рот", "Подрочить", "Лизнуть", "Обкончать"};
    String[] commandsLetter = {"выебать", "трахнуть", "изнасиловать", "делать секс", "разорвать очко", "порвать пизду",
            "дать в рот", "подрочить", "лизнуть", "обкончать"};

    TelegramBot bot;

    public Controller(TelegramBot bot) {
        System.out.println("Started Controller");
        this.bot = bot;
    }

    public void update(Update update) {
        System.out.println("Update is working!");


        System.out.println(update.message());

        if (update.message() != null && update.message().text() != null && !update.message().text().isEmpty() && !update.message().from().isBot() && update.message().replyToMessage() != null) {


            long chatID = update.message().chat().id();
            String updateText = update.message().text();
            long firstUserID = update.message().from().id();
            String firstUserName = update.message().from().lastName() != null ? update.message().from().firstName() + " " + update.message().from().lastName() : update.message().from().firstName();
            String firstUserURL = String.format("[%s](%s)", firstUserName, "tg://openmessage?user_id=" + firstUserID);


            String secondUserName = update.message().replyToMessage().from().lastName() != null ? update.message().replyToMessage().from().firstName() + " " + update.message().replyToMessage().from().lastName() : update.message().replyToMessage().from().firstName();
            long secondUserID = update.message().replyToMessage().from().id();
            String secondUserURL = String.format("[%s](%s)", secondUserName, "tg://openmessage?user_id=" + secondUserID);

            if (updateText.equals(commandsCapital[0]) || updateText.equals(commandsLetter[0]) && !update.message().replyToMessage().from().id().toString().isEmpty()) {
                sendMessageForMarkdown(chatID, String.format("\uD83D\uDC49\uD83D\uDC4C| %s Жестко выебал %s", firstUserURL, secondUserURL));
            } else if (updateText.equals(commandsCapital[1]) || updateText.equals(commandsLetter[1]) && !update.message().replyToMessage().from().id().toString().isEmpty()) {
                sendMessageForMarkdown(chatID, String.format("\uD83E\uDD2C\uD83C\uDF46| %s Жестко оттрахал %s", firstUserURL, secondUserURL));
            } else if (updateText.equals(commandsCapital[2]) || updateText.equals(commandsLetter[2]) && !update.message().replyToMessage().from().id().toString().isEmpty()) {
                sendMessageForMarkdown(chatID, String.format("\uD83D\uDD1E\uD83D\uDE30| %s в темном углу изнасиловал %s", firstUserURL, secondUserURL));
            } else if (updateText.equals(commandsCapital[3]) || updateText.equals(commandsLetter[3]) && !update.message().replyToMessage().from().id().toString().isEmpty()) {
                sendMessageForMarkdown(chatID, String.format("\uD83C\uDF46\uD83E\uDD75| %s Занялся сексом с %s", firstUserURL, secondUserURL));
            } else if (updateText.equals(commandsCapital[4]) || updateText.equals(commandsLetter[4]) && !update.message().replyToMessage().from().id().toString().isEmpty()) {
                sendMessageForMarkdown(chatID, String.format("\uD83E\uDD2C\uD83D\uDE13| %s Разорвал очко %s", firstUserURL, secondUserURL));
            } else if (updateText.equals(commandsCapital[5]) || updateText.equals(commandsLetter[5]) && !update.message().replyToMessage().from().id().toString().isEmpty()) {
                sendMessageForMarkdown(chatID, String.format("\uD83C\uDF51\uD83E\uDD75| %s Разорвал киску %s", firstUserURL, secondUserURL));
            } else if (updateText.equals(commandsCapital[6]) || updateText.equals(commandsLetter[6]) && !update.message().replyToMessage().from().id().toString().isEmpty()) {
                sendMessageForMarkdown(chatID, String.format("\uD83C\uDF46\uD83D\uDE2E\u200D\uD83D\uDCA8| %s Дал в рот %s", firstUserURL, secondUserURL));
            } else if (updateText.equals(commandsCapital[7]) || updateText.equals(commandsLetter[7]) && !update.message().replyToMessage().from().id().toString().isEmpty()) {
                sendMessageForMarkdown(chatID, String.format("\uD83C\uDF46\uD83D\uDD90| %s Подрочил на %s", firstUserURL, secondUserURL));
            } else if (updateText.equals(commandsCapital[8]) || updateText.equals(commandsLetter[8]) && !update.message().replyToMessage().from().id().toString().isEmpty()) {
                sendMessageForMarkdown(chatID, String.format("\uD83D\uDC45\uD83E\uDD75| %s Смачно лизнул %s", firstUserURL, secondUserURL));
            } else if (updateText.equals(commandsCapital[9]) || updateText.equals(commandsLetter[9]) && !update.message().replyToMessage().from().id().toString().isEmpty()) {
                sendMessageForMarkdown(chatID, String.format("\uD83C\uDF46\uD83D\uDCA6| %s Обкончал %s", firstUserURL, secondUserURL));
            }


        } else if (update.message() != null && update.message().text() != null && !update.message().text().isEmpty() && !update.message().from().isBot() && update.message().replyToMessage() == null) {

            long chatID = update.message().chat().id();
            String updateText = update.message().text();
            if (updateText.equals("/start") || updateText.equals("/start@Larichatbot")) {
                sendMessage(chatID, "Привет! Я чат бот для с*кса! Просто добавь меня в чат и дай мне права Администратора!" +
                        "\nЧтобы увидеть список моих комманд отправь мне /help");
            } else if (updateText.equals("/help") || updateText.equals("/help@Larichatbot")) {
                sendMessage(chatID, "Вот список моих комманд:\n" +
                        "РП(Ответом на чье то сообщение)(Можно строчными буквами):\n" +
                        "Выебать" +
                        "\nТрахнуть" +
                        "\nИзнасиловать" +
                        "\nДелать секс" +
                        "\nРазорвать очко" +
                        "\nПорвать пизду" +
                        "\nДать в рот" +
                        "\nПодрочить" +
                        "\nЛизнуть" +
                        "\nОбкончать");
            }

        } else {
            System.out.println("Log");
        }
    }

    public void sendMessage(long chatID, String text) {
        SendMessage sendMessage = new SendMessage(chatID, text);
        bot.execute(sendMessage);
    }

    public void sendMessageForMarkdown(long chatID, String text) {
        SendMessage sendMessage = new SendMessage(chatID, text);
        sendMessage.parseMode(ParseMode.Markdown);
        bot.execute(sendMessage);
    }

}
