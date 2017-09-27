package br.hm.example02;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;

import java.util.concurrent.TimeUnit;

public class ReplaySubjectMain {
    public static void main(String[] args) throws InterruptedException {
        //Guarda cache de todos os item.
        ReplaySubject<Integer> subjects[] = new ReplaySubject[]{buildWithCreate(),buildWithSize2(),buildWithTime()};
        String titles[] = new String[]{"\n---- ReplaySubject create -----\n","\n---- ReplaySubject size2 -----\n", "\n---- ReplaySubject time -----\n"};
        for (int i =0 ; i < subjects.length;i++) {
            ReplaySubject<Integer> subject = subjects[i];
            String title = titles[i];
            System.out.println(title);
            System.out.println("----- Add subscribe 01");
            subject.subscribe(item ->
                    System.out.printf("subscribe 01 item %s\n", item)
            );
            subject.onNext(0);
            Thread.currentThread().sleep(150);
            subject.onNext(1);
            Thread.currentThread().sleep(150);
            subject.onNext(2);
            Thread.currentThread().sleep(250);
            System.out.println("----- Add subscribe 02");
            subject.subscribe(item -> System.out.printf("subscribe 02 item %s\n", item));

            subject.onNext(3);
        }
    }

    public static ReplaySubject<Integer> buildWithCreate(){
        return  ReplaySubject.create();
    }
    public static ReplaySubject<Integer> buildWithSize2(){
        return  ReplaySubject.createWithSize(2);
    }

    public static ReplaySubject<Integer> buildWithTime(){
        return  ReplaySubject.createWithTime(100, TimeUnit.MILLISECONDS, Schedulers.single());
    }
}
