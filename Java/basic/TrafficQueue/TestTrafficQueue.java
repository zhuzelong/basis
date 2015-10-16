/**
 * Test the traffic queue with car and fire engine.
 */
public class TestTrafficQueue
{
    public static void main(String[] args)
    {
        int length=1000;
        TrafficQueue queue=new TrafficQueue(length);
        Car car=new Car("blue", "Ford");
        FireEngine fireEngine=new FireEngine();
        queue.push(car);
        queue.push(fireEngine);
        queue.showQueue();
    }
}
