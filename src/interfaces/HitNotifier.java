package interfaces;

/**
 * indicate that objects that implement it send notifications when they are being hit.
 *
 * @author Elisheva Broyer.
 * @since 10/05/2016.
 */
public interface HitNotifier {
    /**
     * add listener to block's list.
     *
     * @param hl a hit listener.
     */
    void addHitListener(HitListener hl);

    /**
     * remove listener from block's list.
     *
     * @param hl a hit listener.
     */
    void removeHitListener(HitListener hl);
}
