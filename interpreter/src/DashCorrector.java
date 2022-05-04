public class DashCorrector implements ICorrector{
    @Override
    public String execute(String context) {
        while (context.contains("-")) {
            context = context.replace("-", "—");
        } return context;
    }
}
