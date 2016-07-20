package lambdas.lesson2.exercise;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterMap {

    public static class Container<T, R> {
        private final Predicate<T> predicate;
        private final Function<T, R> function;

        public Container(Predicate<T> predicate, Function<T, R> function) {
            this.predicate = predicate;
            this.function = function;
        }

        public Predicate<T> getPredicate() {
            return predicate;
        }

        public Function<T, R> getFunction() {
            return function;
        }
    }

    public static class LazyCollectionHelper<T> {
        public LazyCollectionHelper(List<T> list) {
            // TODO
            throw new UnsupportedOperationException();
        }

        public LazyCollectionHelper<T> filter(Predicate<T> condition) {
            // TODO
            throw new UnsupportedOperationException();
        }

        public <R> LazyCollectionHelper<R> map(Function<T, R> function) {
            // TODO
            throw new UnsupportedOperationException();
        }
    }
}
