package me.jezza.oc.common.core.network.interfaces;

import java.util.List;

import net.minecraft.world.World;

/**
 * This removes the need for the node to have a direct reference to the {@link me.jezza.oc.common.core.network.interfaces.INetworkNodeHandler}
 * This can remove a lot of stupid errors when someone has direct access to the object.
 */
public interface IMessageProcessor<T extends INetworkNode<T>> {

	/**
	 * Method used to post non-physical messages.
	 * These have no physical representative and exist solely on the server-side.
	 *
	 * @param message The message being posted.
	 * @return true if the message was added.
	 */
	boolean postMessage(INetworkMessage<T> message);

	/**
	 * Method used to post entity messages
	 * These exist as a physical entity in the world, as defined by the message itself.
	 * It exists on both the server and client-side.
	 *
	 * @param message The message that was posted.
	 * @return true if the message was added.
	 */
	boolean postMessage(INetworkEntity<T> message);

	/**
	 * If no path was found between pointA(from) and pointB(to) then an empty list will be returned.
	 * The exact method of search is at the liberty of the implementation.
	 * The recommended method would be Breadth First Search. (BFS)
	 *
	 * @param from Starting node
	 * @param to   Finishing node
	 * @return An ordered list starting at: from, and follows a path to: to
	 */
	ISearchResult<T> getPathFrom(T from, T to);

	/**
	 * @return An immutable list of the worlds that it currently resides in.
	 */
	List<World> getNetworkedWorlds();

}
