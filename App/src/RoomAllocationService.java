/**
 * CLASS: RoomAllocationService
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Ensures:
 * - Unique room IDs
 * - No double booking
 * - Immediate inventory update
 *
 * @version 6.0
 */

import java.util.*;

public class RoomAllocationService {

    // Stores all allocated room IDs globally
    private Set<String> allocatedRoomIds;

    // Stores assigned room IDs grouped by room type
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Allocates room for a reservation
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();
        int available = inventory.getAvailability(roomType);

        // Check availability
        if (available > 0) {

            String roomId = generateRoomId(roomType);

            // Ensure uniqueness (extra safety)
            while (allocatedRoomIds.contains(roomId)) {
                roomId = generateRoomId(roomType);
            }

            // Store globally
            allocatedRoomIds.add(roomId);

            // Store by room type
            assignedRoomsByType
                    .computeIfAbsent(roomType, k -> new HashSet<>())
                    .add(roomId);

            // Update inventory
            inventory.updateAvailability(roomType, available - 1);

            // Confirm booking
            System.out.println(
                    "Booking confirmed for Guest: " +
                            reservation.getGuestName() +
                            ", Room ID: " + roomId
            );

        } else {
            System.out.println(
                    "Booking FAILED for Guest: " +
                            reservation.getGuestName() +
                            " (No " + roomType + " rooms available)"
            );
        }
    }

    /**
     * Generates unique room ID
     */
    private String generateRoomId(String roomType) {

        int count = assignedRoomsByType
                .getOrDefault(roomType, new HashSet<>())
                .size() + 1;

        return roomType + "-" + count;
    }
}