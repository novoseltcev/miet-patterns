public class EnterCorrector implements ICorrector{
    @Override
    public String execute(String context) {
        while (context.contains("\n\n"))
            context = context.replace("\n\n", "\n");

        while (context.contains("\n\r\n\r"))
            context = context.replace("\n\r\n\r", "\n\r");

        while (context.contains("\r\n\r\n"))
            context = context.replace("\r\n\r\n", "\r\n");

        while (context.contains("\n\t"))
            context = context.replace("\n\t", "\n");

        return context.replace("\n ", "\n");
    }
}
