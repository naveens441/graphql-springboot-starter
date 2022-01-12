package graphqlspringbootstarter.graphqlspringbootstarter.resolver;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import graphqlspringbootstarter.graphqlspringbootstarter.pojo.Score;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
@Component
public class Subscription implements GraphQLSubscriptionResolver {
    public Publisher<Score> scores(String title) {
        Observable<Score> observable = Observable.create(e -> {
            ScheduledExecutorService scheduledExecutorService = Executors
                    .newScheduledThreadPool(3);
            scheduledExecutorService.scheduleAtFixedRate(() -> {
                Score score = Score.builder().title(title).score((int) Math.floor(Math.random() * 5)).build();
                e.onNext(score);
            }, 0, 2, TimeUnit.SECONDS);
        });
        ConnectableObservable connect=observable.share().publish();
        connect.connect();
        return connect.toFlowable(BackpressureStrategy.BUFFER);
    }
}