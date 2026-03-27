/**
 * CLASS: ReservationValidator
 *
 * Handles validation logic
 *
 * @version 9.0
 */
public class ReservationValidator {

    public void validate(
            String guestName,
            String roomType,
            RoomInventory inventory
    ) throws InvalidBookingException {

        // Validate guest name
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Normalize input
        roomType = roomType.trim();

        // Validate room type
        if (!(roomType.equalsIgnoreCase("Single") ||
                roomType.equalsIgnoreCase("Double") ||
                roomType.equalsIgnoreCase("Suite"))) {

            throw new InvalidBookingException("Invalid room type selected.");
        }

        // Normalize to standard format
        String normalizedRoomType =
                roomType.substring(0, 1).toUpperCase() +
                        roomType.substring(1).toLowerCase();

        // Validate availability
        int available = inventory.getAvailability(normalizedRoomType);

        if (available <= 0) {
            throw new InvalidBookingException(
                    "No rooms available for selected type."
            );
        }
    }
}