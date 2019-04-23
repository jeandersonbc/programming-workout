package segtree;

/**
 * Auxiliary interface to verify if a data structure stores the data as expected.
 *
 * @param <T> Type of the representation
 * @author Jeanderson Candido (https://github.com/jeandersonbc)
 */
public interface Representable<T> {
    /**
     * Exposes a copy of the internal representation.
     * Must be side-effects free.
     *
     * @return The representation of this entity.
     */
    T internalRepresentation();
}
