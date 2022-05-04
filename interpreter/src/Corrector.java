import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Corrector implements ICorrector {
    List<ICorrector> correctors;

    Corrector() {
        correctors = new LinkedList<>() {{
            add(new DashCorrector());
            add(new TabCorrector());
            add(new QuoteCorrector());
            add(new SpaceCorrector());
            add(new EnterCorrector());
        }};
    }

    @Override
    public String execute(String context) {
        for (ICorrector corrector: correctors) {
            context = corrector.execute(context);
        }
        return context;
    }
}
