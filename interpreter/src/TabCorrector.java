public class TabCorrector implements ICorrector{
    @Override
    public String execute(String context) {
        while (context.contains("\t\t")) {
            context = context.replace("\t\t", "\t");
        }
        while (context.contains("  ")) {
            context = context.replace("  ", " ");
        }
        return context;
    }
}
