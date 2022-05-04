public class SpaceCorrector implements ICorrector{
    @Override
    public String execute(String context) {
        return context
                .replace("( ", "(")
                .replace(" )", ")")
                .replace(" ,", ",")
                .replace(" !", "!")
                .replace(" ?", "?")
                .replace(" .", ".");
    }
}
