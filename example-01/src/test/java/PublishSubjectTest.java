import io.reactivex.subjects.PublishSubject;
import org.junit.Test;

public class PublishSubjectTest {

    @Test
    public void publishSubjectWithCreate() {
        System.out.println("Exaple hello world");

        PublishSubject<String> subject = PublishSubject.create();
        subject.onNext("Não imprime");
        subject.subscribe(System.out::println);
        subject.onNext("Hello");
        subject.onNext("World");
    }
}
