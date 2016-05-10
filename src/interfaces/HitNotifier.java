package interfaces;

/**
 * indicate that objects that implement it send notifications when they are being hit.
 *
 * @author Elisheva Broyer.
 * @since 10/05/2016.
 */
public interface HitNotifier {
    // Add hl as a listener to hit events.
    void addHitListener(HitListener hl);

    // Remove hl from the list of listeners to hit events.
    void removeHitListener(HitListener hl);
}
