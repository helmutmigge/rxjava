import io.reactivex.subjects.BehaviorSubject;
import org.junit.Test;

public class BehaviorSubjectTest {

    /**
     * Testa o BehaviorSubject. Ele armazena somente o ultimo item informado.
     * Comportamento semelhante ao RplaySubject size 1
     */
    @Test
    public void behaviorSubjectWithCreate() {
        BehaviorSubject<Integer> subject = BehaviorSubject.create();
        subject.onNext(0);
        subject.onNext(1);
        subject.onNext(2);
        subject.subscribe(item -> System.out.printf("item %d\n", item)
                , throwable -> System.out.printf("Error - %s", throwable)
                , () -> System.out.println("Complete"));
        subject.onNext(3);
        subject.onComplete();
    }
}
