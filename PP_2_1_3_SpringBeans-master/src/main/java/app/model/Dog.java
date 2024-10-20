package app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dog")
public class Dog extends Animal {
    private AnimalsCage animalsCage;
    @Autowired
    public Dog(AnimalsCage animalsCage){
        this.animalsCage=animalsCage;
    }
    @Override
    public String toString() {
        return "Im a dog";
    }
}
