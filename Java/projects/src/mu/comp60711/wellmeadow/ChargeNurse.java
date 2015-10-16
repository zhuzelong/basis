package mu.comp60711.wellmeadow;
/**
 * A role in charge of patient and ward management.
 */
interface ChargeNurse 
{
    // Allocate a patient to a ward
    InWardList allocate(Patient patient, Ward ward);
    
    // Allocate a patient to a waiting list
    WaitingList makeWait(Patient patient);

    // Apply for supply, fill in a requisition form
    Requisition require();
}

