import com.bosonit.ServiceLocatorFactoryBean.model.Vehicle;
import com.bosonit.ServiceLocatorFactoryBean.registry.AdapterService;
import org.springframework.stereotype.Service;

@Service("Bus")
public class BusService implements AdapterService<Vehicle> {

    @Override
    public void process(Vehicle request){
        System.out.println("This is a service for buses - " + request.toString());
    }


}

