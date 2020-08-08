package ua.sytor.deviantartclient;

import org.junit.Test;

import java.util.UUID;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;


public class ExampleUnitTest {

    static void log(String str) {
        Thread currentThread = Thread.currentThread();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        StackTraceElement callingElement = stackTrace[2];

        String threadName = currentThread.getName();

        String[] classFullPackage = callingElement.getClassName().split("\\.");
        String className = classFullPackage[classFullPackage.length - 1];

        String methodName = callingElement.getMethodName();

        String log = String.format("%s %s[%s] %s", threadName, className, methodName, str);

        System.out.println(log);
    }

    @Test
    public void test() {

        BehaviorSubject<Integer> subject = BehaviorSubject.create();

        Disposable d = subject.observeOn(Schedulers.io())
                .switchMap((i) -> {
                            System.out.println("1");
                            return Completable.complete()
                                    .andThen(Completable.fromRunnable(() -> {
                                        System.out.println(UUID.randomUUID().toString());
                                    }))
                                    .andThen(Observable.just(true));
                        }
                )
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.io())
                .subscribe((a) -> {
                    System.out.println("3");
                });

        System.out.println("0");
        subject.onNext(1);

        try {
            Thread.sleep(600);
            subject.onNext(2);
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        Single
//                .fromCallable(() -> {
//                    return true;
//                })
//                .flatMapCompletable((a) -> {
//                    return Completable.complete();
//                })
//                .doOnSubscribe((d) -> {
//                    System.out.println("doOnSubscribe");
//                })
//                .subscribe(() -> {
//                    System.out.println("completed");
//                });

    }

    @Test
    public void test2() {
        log("123");
    }

}