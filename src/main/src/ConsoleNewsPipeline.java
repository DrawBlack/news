import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class ConsoleNewsPipeline implements Pipeline{


    @Override
    public void process(ResultItems resultItems, Task task) {
        System.out.println(resultItems.getAll());
    }
}
