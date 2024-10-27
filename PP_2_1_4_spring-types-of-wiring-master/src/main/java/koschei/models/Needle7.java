package koschei.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Needle7 {

    private Deth8 deth;
    @Autowired
    public Needle7(Deth8 deth){
        this.deth=deth;
    }

    @Override
    public String toString() {
        return ", смерть Кощея на игле :( " + deth;
    }
}
