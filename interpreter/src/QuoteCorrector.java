public class QuoteCorrector implements ICorrector{
    @Override
    public String execute(String context) {
        var counter = 0;
        while (context.contains("\""))
            context = context.replaceFirst("\"", (counter++) % 2 == 0 ? "«": "»");
        return context;
    }
}
