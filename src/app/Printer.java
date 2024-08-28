package app;

public interface Printer {

    void print (MessagePrint.Message message);
}

class MessagePrint implements Printer {
    public static class Message {
        private String text;
        private String sender;

        public Message(String text, String sender) {
            this.text = text;
            this.sender = sender;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }
    }

    @Override
    public void print(Message message) {
        if ((message.getText() == null || message.getText().isEmpty()) &&
                (message.getSender() == null || message.getSender().isEmpty())) {
            Printer noname =new Printer() {
                @Override
                public void print(Message message) {
                    System.out.println("Empty message from anonymous");
                }
            };
            noname.print(message);
        } else if (message.getSender() == null || message.getSender().isEmpty()) {
            System.out.println("Anonymous user sent a message: " + message.getText());
        } else if (message.getText() == null || message.getText().isEmpty()) {
            System.out.println(message.getSender() + " No message.");
        } else {
            System.out.println("User: " + message.getSender() + " sent a message: " + message.getText());
        }
    }
}
