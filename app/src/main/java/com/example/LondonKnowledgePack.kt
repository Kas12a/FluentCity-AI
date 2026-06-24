package com.example

data class LondonScenario(
    val id: String,
    val title: String,
    val level: String, // "Beginner", "Intermediate", "Advanced"
    val situation: String,
    val goal: String,
    val starterPhrase: String,
    val localTip: String
)

data class UsefulPhrase(
    val phrase: String,
    val meaning: String,
    val context: String
)

data class CommonMistake(
    val incorrect: String,
    val correct: String,
    val explanation: String
)

data class LocalExpression(
    val expression: String,
    val meaning: String,
    val example: String
)

data class LondonCategoryPack(
    val categoryId: String,
    val categoryName: String,
    val icon: String,
    val beginnerScenarios: List<LondonScenario>,
    val intermediateScenarios: List<LondonScenario>,
    val advancedScenarios: List<LondonScenario>,
    val usefulPhrases: List<UsefulPhrase>,
    val commonMistakes: List<CommonMistake>,
    val localExpressions: List<LocalExpression>
)

object LondonEnglishKnowledgePack {
    val categories: List<LondonCategoryPack> = listOf(
        // Category 1: Transport and TFL
        LondonCategoryPack(
            categoryId = "transport_tfl",
            categoryName = "Transport and TFL",
            icon = "🚇",
            beginnerScenarios = listOf(
                LondonScenario(
                    id = "tfl_beg_1",
                    title = "Buying an Oyster Card",
                    level = "Beginner",
                    situation = "You have just landed at Heathrow Airport and want to purchase an Oyster card with credit at the station terminal.",
                    goal = "Politely ask the ticketing agent for an Oyster card with twenty pounds of pre-loaded pay-as-you-go credit.",
                    starterPhrase = "Hello! Could I please buy a new Oyster card and put twenty pounds on it?",
                    localTip = "Ticket offices are often replaced by machines, but TfL visitor assistants in pink high-visibility vests are always around to help."
                ),
                LondonScenario(
                    id = "tfl_beg_2",
                    title = "Asking for the Tube Platform",
                    level = "Beginner",
                    situation = "You are inside Victoria Station, and you are unsure which platform goes southbound on the Victoria Line.",
                    goal = "Ask a fellow traveler to confirm which platform you need to reach Brixton.",
                    starterPhrase = "Excuse me, does the southbound Victoria Line platform go towards Brixton from here?",
                    localTip = "Look for directional signs indicating 'Northbound' or 'Southbound' inside the station corridors."
                ),
                LondonScenario(
                    id = "tfl_beg_3",
                    title = "Barrier Contactless Issue",
                    level = "Beginner",
                    situation = "Your phone's digital wallet did not work at the ticket barrier, showing a red light when you tried to tap through.",
                    goal = "Approach the barrier staff and explain that your card reader showed a red light.",
                    starterPhrase = "Hi there, sorry, but my contactless payment showed a red light when I tapped the reader.",
                    localTip = "Always check that your phone is unlocked and set to express transit mode to avoid barrier delays."
                ),
                LondonScenario(
                    id = "tfl_beg_4",
                    title = "Locating the Bus Stop",
                    level = "Beginner",
                    situation = "You are on a high street in London, trying to find the nearest bus stop that takes you towards Trafalgar Square.",
                    goal = "Ask a pedestrian for directions to the correct bus stop letter.",
                    starterPhrase = "Excuse me, do you know which bus stop goes towards Trafalgar Square?",
                    localTip = "Bus stops in London are marked with letters (e.g., Stop A, Stop GP) on top of the sign post."
                ),
                LondonScenario(
                    id = "tfl_beg_5",
                    title = "Confirming Waterloo Stop",
                    level = "Beginner",
                    situation = "You are sitting on a Jubilee line train and want to make sure it stops at Waterloo Station.",
                    goal = "Ask the passenger sitting next to you if this train stops at Waterloo.",
                    starterPhrase = "Sorry to bother you, but does this Jubilee line train stop at Waterloo?",
                    localTip = "The automated announcements will say 'This train terminates at...' or list the next stations on the line."
                )
            ),
            intermediateScenarios = listOf(
                LondonScenario(
                    id = "tfl_int_1",
                    title = "Inquiring about Line Delays",
                    level = "Intermediate",
                    situation = "There is an active delay announcement on the Victoria Line at Green Park Station.",
                    goal = "Ask a TfL station agent about the expected delay length and if it is better to take another route.",
                    starterPhrase = "Excuse me, I heard there are severe delays on the Victoria line. Is it worth taking the bus instead?",
                    localTip = "Londoners frequently ask TfL staff for alternative routes during delays to save time."
                ),
                LondonScenario(
                    id = "tfl_int_2",
                    title = "Asking for alternative bus routes",
                    level = "Intermediate",
                    situation = "The Northern Line is suspended, and you need to reach King's Cross. You decide to take a local red bus.",
                    goal = "Ask the TfL assistant which specific bus number you should take and where to board it.",
                    starterPhrase = "Since the Northern Line is down, could you tell me which bus goes directly to King's Cross?",
                    localTip = "Bus journeys enjoy a 'hopper fare' where any additional bus trips within one hour of tapping in are free."
                ),
                LondonScenario(
                    id = "tfl_int_3",
                    title = "TfL Top-up Assistance",
                    level = "Intermediate",
                    situation = "You set up auto-top-up on your TfL app, but your card shows an 'insufficient balance' warning anyway.",
                    goal = "Explain the discrepancy to a visitor assistant and ask them to check your card's status.",
                    starterPhrase = "Hi, my app shows I have active auto-top-up, but the barrier says my card has insufficient funds.",
                    localTip = "It can take up to 24 hours for online top-ups to register on physical Oyster cards when tapped."
                ),
                LondonScenario(
                    id = "tfl_int_4",
                    title = "Elizabeth Line Speed Inquiry",
                    level = "Intermediate",
                    situation = "You are at Paddington Station and are debating whether to take the standard Central line or the new Elizabeth Line.",
                    goal = "Ask a commuter which option is quicker and more comfortable to reach Canary Wharf.",
                    starterPhrase = "Excuse me, is it much faster to take the Elizabeth Line to Canary Wharf than the Tube?",
                    localTip = "The Elizabeth Line is much wider, air-conditioned, and faster, though fares are sometimes slightly higher depending on the route."
                ),
                LondonScenario(
                    id = "tfl_int_5",
                    title = "Refunding a Double Charge",
                    level = "Intermediate",
                    situation = "You noticed on your bank statement that TfL charged you a maximum fare because you forgot to tap out yesterday.",
                    goal = "Call TfL support or talk to an agent to request a correction for your incomplete journey.",
                    starterPhrase = "Hello, I was charged a maximum fare yesterday because the exit gate was open and I didn't tap out.",
                    localTip = "Incomplete journeys can be corrected easily online or via the TfL Oyster app to claim refunds."
                )
            ),
            advancedScenarios = listOf(
                LondonScenario(
                    id = "tfl_adv_1",
                    title = "Delay Repay Claim",
                    level = "Advanced",
                    situation = "Your train on National Rail / Overground was delayed by 45 minutes, causing you to miss an important meeting.",
                    goal = "Contact customer relations to argue for full compensation under the Delay Repay scheme.",
                    starterPhrase = "I would like to file a compensation claim under the Delay Repay policy for yesterday's 45-minute delay on the Overground.",
                    localTip = "Under Delay Repay rules, you are entitled to compensation if your train is delayed by 15 minutes or more."
                ),
                LondonScenario(
                    id = "tfl_adv_2",
                    title = "Penalty Fare Appeal",
                    level = "Advanced",
                    situation = "A ticket inspector issued you a penalty fare notice because your phone ran out of battery, preventing you from showing your ticket.",
                    goal = "Politely but firmly explain the situation to the inspector and ask how to lodge a formal appeal online.",
                    starterPhrase = "My phone died just before boarding. I have an active season ticket; is it possible to appeal this penalty notice online?",
                    localTip = "Never argue aggressively with ticket inspectors. Accept the notice and appeal formally with proof of purchase."
                ),
                LondonScenario(
                    id = "tfl_adv_3",
                    title = "Planning Late-Night Travel",
                    level = "Advanced",
                    situation = "It is 2 AM on a Saturday, and the tube line you need is closed for engineering works. You must map out a route home.",
                    goal = "Consult a station worker or transport assistant to assemble a multi-bus night journey to South London.",
                    starterPhrase = "Since the Victoria line isn't running tonight, what is the best combination of night buses to get to Brixton?",
                    localTip = "All night bus routes are prefixed with the letter 'N', and the hopper fare applies exactly the same way."
                ),
                LondonScenario(
                    id = "tfl_adv_4",
                    title = "TfL Fare Structure Debate",
                    level = "Advanced",
                    situation = "You are discussing off-peak caps and contactless pricing zones with a colleague who wants to understand how capping works.",
                    goal = "Compare Oyster caps, contactless card capping, and weekly travelcards to recommend the cheapest choice.",
                    starterPhrase = "Actually, contactless is capped daily and weekly, so you rarely need a weekly travelcard unless you travel off-peak frequently.",
                    localTip = "Contactless daily capping automatically calculates the cheapest fare combination for your travel zone."
                ),
                LondonScenario(
                    id = "tfl_adv_5",
                    title = "Lost Property Detailed Claim",
                    level = "Advanced",
                    situation = "You left a high-value laptop bag containing sensitive work files on a Piccadilly Line train.",
                    goal = "Explain the exact details of the lost item, including train time, coach position, and physical description to the TfL Lost Property office.",
                    starterPhrase = "I left a black leather laptop bag on a Piccadilly line train heading eastbound from South Kensington at approximately 3:15 PM today.",
                    localTip = "TfL Lost Property is centralized at Pelham Street, but items can take up to 3-5 days to appear on their system."
                )
            ),
            usefulPhrases = listOf(
                UsefulPhrase("Mind the gap, please.", "Pay attention to the space between the train and the platform.", "Heard constantly on Underground platforms."),
                UsefulPhrase("Is this line suspended?", "Is service currently stopped on this specific line?", "Asking about major travel disruptions."),
                UsefulPhrase("What stop is next?", "Which station is the train arriving at next?", "Confirming your current location."),
                UsefulPhrase("I missed my connection.", "I arrived too late to catch my next scheduled train or bus.", "Explaining travel delays."),
                UsefulPhrase("Does this stop on the high street?", "Does this bus drop passengers off on the main shopping street?", "Asking a bus driver.")
            ),
            commonMistakes = listOf(
                CommonMistake("Can I buy a subway card?", "Could I buy an Oyster card, please?", "Londoners call the underground transit system the 'Tube' or 'Underground', never the 'subway'."),
                CommonMistake("I'm going to tap on.", "I'm going to touch in.", "The correct local verbs are 'touch in' and 'touch out' (or 'tap in'/'tap out')."),
                CommonMistake("Where is the metro station?", "Where is the Tube station?", "'Metro' is used in Paris or Newcastle, but London strictly uses 'Underground' or 'Tube'."),
                CommonMistake("Wait on platform 4 track 2.", "Wait on platform 4.", "In the UK, trains arrive at 'platforms', and referring to 'tracks' is rare and sounds American."),
                CommonMistake("I have to change the line.", "I need to change lines.", "The natural expression is 'change lines' or 'interchange at [station]' rather than 'change the line'.")
            ),
            localExpressions = listOf(
                LocalExpression("Tube", "The London Underground train network.", "I usually take the Tube to save time on my commute."),
                LocalExpression("Oyster card", "The contactless electronic smartcard for London transport.", "Make sure to top up your Oyster card before peak hours."),
                LocalExpression("TfL", "Transport for London, the government body running transit.", "You can check the TfL app for real-time line closures."),
                LocalExpression("Elizabeth Line", "The new high-speed east-west railway line in London.", "The Elizabeth Line is incredibly fast and has air conditioning."),
                LocalExpression("Hopper fare", "TfL bus fare system allowing free second bus rides in an hour.", "Thanks to the hopper fare, my second bus journey didn't cost a penny.")
            )
        ),

        // Category 2: GP and pharmacy
        LondonCategoryPack(
            categoryId = "gp_pharmacy",
            categoryName = "GP and pharmacy",
            icon = "🏥",
            beginnerScenarios = listOf(
                LondonScenario(
                    id = "gp_beg_1",
                    title = "Registering at a local GP",
                    level = "Beginner",
                    situation = "You have recently moved to a new flat in London and want to register with the closest NHS General Practice (GP) clinic.",
                    goal = "Ask the receptionist what documents you need to bring to complete registration.",
                    starterPhrase = "Hello, I'd like to register as a new NHS patient at this GP practice. What forms or ID do I need to provide?",
                    localTip = "Under NHS guidelines, GP surgeries cannot refuse registration based on lack of proof of address or immigration status."
                ),
                LondonScenario(
                    id = "gp_beg_2",
                    title = "Buying over-the-counter painkillers",
                    level = "Beginner",
                    situation = "You have a severe headache and want to buy some paracetamol or ibuprofen at a local Boots pharmacy.",
                    goal = "Ask the pharmacist on duty for advice on the best over-the-counter headache relief.",
                    starterPhrase = "Hi there, I have a really bad headache. What over-the-counter pain relief do you recommend?",
                    localTip = "Supermarkets and pharmacies sell basic painkillers like paracetamol for under 50p, but there is a legal limit on how many packs you can buy at once."
                ),
                LondonScenario(
                    id = "gp_beg_3",
                    title = "Booking an urgent GP slot",
                    level = "Beginner",
                    situation = "You woke up with a high fever and want to book an emergency same-day appointment at your GP surgery.",
                    goal = "Call the GP receptionist right at 8:00 AM to request a same-day urgent consultation.",
                    starterPhrase = "Good morning, I have a very high fever and feel extremely unwell. Do you have any urgent same-day slots available?",
                    localTip = "GP telephone lines in London are extremely busy at 8 AM. Be prepared to wait in an automated queue."
                ),
                LondonScenario(
                    id = "gp_beg_4",
                    title = "Picking up a prescription",
                    level = "Beginner",
                    situation = "Your doctor sent an electronic prescription to your local pharmacy, and you are here to collect it.",
                    goal = "State your name, address, and date of birth to the counter staff to retrieve your medication.",
                    starterPhrase = "Hello, I'm here to collect a prescription for my name, which was sent over by my GP yesterday.",
                    localTip = "NHS prescriptions in England have a flat standard fee per item unless you qualify for an exemption."
                ),
                LondonScenario(
                    id = "gp_beg_5",
                    title = "Asking about prescription exemption",
                    level = "Beginner",
                    situation = "You have a medical condition (like diabetes) or a prepayment certificate that exempts you from paying the prescription charge.",
                    goal = "Tell the pharmacist that you are exempt from the standard fee and show your exemption card.",
                    starterPhrase = "I don't need to pay for this prescription as I hold a valid NHS medical exemption certificate.",
                    localTip = "Always sign the back of the prescription form indicating your correct exemption category to avoid penalty fines."
                )
            ),
            intermediateScenarios = listOf(
                LondonScenario(
                    id = "gp_int_1",
                    title = "Describing cold symptoms to GP",
                    level = "Intermediate",
                    situation = "You are in a consultation room describing a persistent cough and sore throat that has lasted for over two weeks.",
                    goal = "Clearly explain your symptoms, duration, and ask if you need antibiotics or just rest.",
                    starterPhrase = "I've had a persistent dry cough and a sore throat for over two weeks now, and it doesn't seem to be getting any better.",
                    localTip = "NHS GPs rarely prescribe antibiotics for viral infections like colds to prevent antibiotic resistance."
                ),
                LondonScenario(
                    id = "gp_int_2",
                    title = "Requesting a repeat prescription",
                    level = "Intermediate",
                    situation = "You are running low on your regular asthma inhaler and need to request a repeat prescription from your GP surgery.",
                    goal = "Explain to the clinic assistant that you need to reorder your regular medication via the online system.",
                    starterPhrase = "Hello, I need to request a repeat prescription for my asthma inhaler as it is running low.",
                    localTip = "Most GPs use the Electronic Prescription Service (EPS), which sends prescriptions directly to your designated chemist."
                ),
                LondonScenario(
                    id = "gp_int_3",
                    title = "Consulting pharmacist on minor ailment",
                    level = "Intermediate",
                    situation = "You have a mild skin rash but do not want to wait days for a GP appointment. You seek advice from a local pharmacist.",
                    goal = "Ask the pharmacist if they can recommend a cream under the NHS Pharmacy First service.",
                    starterPhrase = "Hi, I have this mild rash on my arm. Could you recommend a cream, or do I need to see a doctor for this?",
                    localTip = "The NHS Pharmacy First scheme allows pharmacists to provide advice and write prescriptions for certain minor conditions."
                ),
                LondonScenario(
                    id = "gp_int_4",
                    title = "Rescheduling a GP consultation",
                    level = "Intermediate",
                    situation = "You have an appointment booked at 10 AM tomorrow, but an urgent work meeting has come up.",
                    goal = "Call the GP receptionist to reschedule your appointment to later in the week.",
                    starterPhrase = "Hi, I have a consultation booked for tomorrow at 10 AM, but I need to reschedule it due to a work clash.",
                    localTip = "Cancel as early as possible. Missed appointments cost the NHS millions and delay care for others."
                ),
                LondonScenario(
                    id = "gp_int_5",
                    title = "Asking about private vs. NHS prescriptions",
                    level = "Intermediate",
                    situation = "A specialist gave you a private prescription, and you want to know if your GP can convert it to an NHS one to save money.",
                    goal = "Inquire with the GP receptionist or pharmacist about the policy for converting private prescriptions to NHS ones.",
                    starterPhrase = "I have a private prescription from a consultant. Is it possible to have my GP convert this to an NHS prescription?",
                    localTip = "GPs are not obligated to convert private prescriptions and will only do so if it complies with local NHS guidelines."
                )
            ),
            advancedScenarios = listOf(
                LondonScenario(
                    id = "gp_adv_1",
                    title = "Requesting a specialist referral",
                    level = "Advanced",
                    situation = "You have chronic back pain that physiotherapy hasn't resolved, and you want to ask your GP for an NHS referral to an orthopedic specialist.",
                    goal = "Construct a persuasive case detailing your treatment history and politely request an official specialist referral.",
                    starterPhrase = "Given that the physiotherapy sessions haven't alleviated my chronic back pain, I'd like to request an NHS referral to a specialist.",
                    localTip = "NHS referrals require a clear clinical pathway. Be prepared to explain why previous primary care steps have failed."
                ),
                LondonScenario(
                    id = "gp_adv_2",
                    title = "Requesting a sick note (Med 3)",
                    level = "Advanced",
                    situation = "You have been off work for 8 days due to severe stress or illness and your employer requires a formal Fit Note (sick note).",
                    goal = "Explain your condition to your GP, explain that you have self-certified for 7 days, and request a Med 3 Fit Note.",
                    starterPhrase = "I have been unable to work for over a week due to severe stress. Since my self-certification period has ended, could I get a Fit Note, please?",
                    localTip = "You can self-certify for illness for up to 7 calendar days. After that, your employer will require a doctor's Fit Note."
                ),
                LondonScenario(
                    id = "gp_adv_3",
                    title = "Reporting GP service complaint",
                    level = "Advanced",
                    situation = "You had an extremely unprofessional interaction with a GP at your local surgery who dismissed your symptoms without examination.",
                    goal = "Speak to the practice manager to register a formal complaint and request a change of assigned doctor.",
                    starterPhrase = "I would like to speak to the practice manager to lodge a formal complaint regarding the dismissive treatment I received today.",
                    localTip = "Every NHS GP practice has a formal complaints procedure and an designated manager who must investigate your concerns."
                ),
                LondonScenario(
                    id = "gp_adv_4",
                    title = "Navigating 111 out-of-hours service",
                    level = "Advanced",
                    situation = "It is 11 PM on a Sunday, and your child has developed a worrying ear infection. You call NHS 111 for advice.",
                    goal = "Describe the symptoms clearly, answer the triage questions, and ask if you need to visit an urgent care center or A&E.",
                    starterPhrase = "My young child has developed a sudden, severe earache and a fever tonight. We're calling for advice on whether to visit urgent care.",
                    localTip = "NHS 111 is a free telephone and online service that provides medical triage and directs you to the right local service."
                ),
                LondonScenario(
                    id = "gp_adv_5",
                    title = "Discussing vaccine options",
                    level = "Advanced",
                    situation = "You are planning a trip to a tropical country and want to discuss necessary travel vaccinations and costs with the GP travel clinic.",
                    goal = "Enquire about which vaccines are covered on the NHS and which ones require a private fee.",
                    starterPhrase = "I'm traveling to South America next month and need to confirm which vaccinations are covered under the NHS and which are private.",
                    localTip = "Some travel vaccines (like hepatitis A) are free on the NHS, while others (like yellow fever) always incur a private charge."
                )
            ),
            usefulPhrases = listOf(
                UsefulPhrase("Could I register with a GP here?", "Am I eligible to join this doctor's clinic as a patient?", "Approaching clinic reception."),
                UsefulPhrase("Is this prescription free?", "Do I need to pay the NHS flat charge for this medicine?", "At the pharmacy counter."),
                UsefulPhrase("I need to see a doctor urgently.", "I require an immediate, same-day medical appointment.", "Calling the GP receptionist."),
                UsefulPhrase("I'd like to repeat my prescription.", "I need to reorder my regular monthly medication.", "Requesting regular medication."),
                UsefulPhrase("Do I need an appointment for this?", "Can I walk in or must I book a slot in advance?", "Asking a pharmacist about advice.")
            ),
            commonMistakes = listOf(
                CommonMistake("I want to register with the clinic.", "I'd like to register with a GP surgery.", "In the UK, primary care clinics are almost always called 'GP surgeries' or 'GP practices'."),
                CommonMistake("Can I get a sick paper?", "Could I request a Fit Note, please?", "The official term is a 'Fit Note' or 'Med 3 form', formerly known as a 'sick note'."),
                CommonMistake("I have to see a therapist.", "I need an NHS referral to a specialist.", "Under the NHS, you cannot book a specialist directly; you must get a 'referral' from your GP."),
                CommonMistake("Where is the drugstore?", "Where is the pharmacy / chemist?", "In the UK, they are called 'pharmacies' or 'chemists' (e.g., Boots), never 'drugstores'."),
                CommonMistake("I want pills for pain.", "Could I get some paracetamol, please?", "Using direct demands sounds blunt. Use soft modal requests and name specific items like 'paracetamol' or 'painkillers'.")
            ),
            localExpressions = listOf(
                LocalExpression("GP", "General Practitioner (family doctor).", "I need to book an appointment with my GP this week."),
                LocalExpression("Surgery", "The medical clinic where your GP operates.", "The GP surgery is located just off the high street."),
                LocalExpression("Chemist", "A local pharmacy selling medicines and toiletries.", "I'll pop into the local chemist to pick up some cough syrup."),
                LocalExpression("Fit Note", "Official medical certificate proving illness to your employer.", "My manager asked me for a Fit Note because I've been off for eight days."),
                LocalExpression("NHS 111", "Free medical helpline for non-emergency advice.", "If you're unsure where to go, ring NHS 111 for triage assistance.")
            )
        ),

        // Category 3: Housing and landlord
        LondonCategoryPack(
            categoryId = "housing_landlord",
            categoryName = "Housing and landlord",
            icon = "🏠",
            beginnerScenarios = listOf(
                LondonScenario(
                    id = "house_beg_1",
                    title = "Inquiring about flat viewing",
                    level = "Beginner",
                    situation = "You saw an advertisement for a one-bedroom flat online and want to book a viewing with the letting agent.",
                    goal = "Ask the agent if the flat is still available and schedule a viewing for this Saturday.",
                    starterPhrase = "Hello, I'm calling about the one-bedroom flat advertised on Rightmove. Is it still available for viewings?",
                    localTip = "The London rental market is extremely fast-paced. Good flats are often let within hours of being advertised."
                ),
                LondonScenario(
                    id = "house_beg_2",
                    title = "Reporting a broken appliance",
                    level = "Beginner",
                    situation = "The washing machine in your rented flat has stopped spinning, leaving your clothes soaked.",
                    goal = "Send a text or email to your landlord describing the issue and asking when a repairman can come.",
                    starterPhrase = "Hi, the washing machine in the flat has stopped spinning. Could you please arrange for someone to take a look?",
                    localTip = "Under UK tenancy laws, landlords are legally responsible for maintaining major white goods and appliances."
                ),
                LondonScenario(
                    id = "house_beg_3",
                    title = "Asking about bills inclusion",
                    level = "Beginner",
                    situation = "You are discussing a flat share with a landlord or lead tenant and want to know what utilities are included.",
                    goal = "Confirm if Council Tax, water, electricity, and broadband are covered in the monthly rent.",
                    starterPhrase = "Does the monthly rent include all bills, such as Council Tax, electricity, and water?",
                    localTip = "Council Tax is a separate fee paid to the local borough council and is rarely included in private tenancies unless explicitly stated."
                ),
                LondonScenario(
                    id = "house_beg_4",
                    title = "Paying rent delay notification",
                    level = "Beginner",
                    situation = "Your salary payment is delayed, meaning you will pay your rent three days late this month.",
                    goal = "Politely warn your landlord about the delay and confirm the exact date you will transfer the funds.",
                    starterPhrase = "I'm very sorry, but my salary transfer is slightly delayed. I will be transferring this month's rent by Thursday.",
                    localTip = "Landlords appreciate proactive communication. Informing them in advance helps maintain a good relationship."
                ),
                LondonScenario(
                    id = "house_beg_5",
                    title = "Confirming inventory check",
                    level = "Beginner",
                    situation = "You are moving into your new flat today and the agent has handed you an inventory list.",
                    goal = "Tell the agent that you will review the list, take photos, and return it with your notes.",
                    starterPhrase = "Thank you for the inventory list. I will go through it, take photos, and send back any comments within three days.",
                    localTip = "An inventory check-in list is vital for protecting your security deposit when you move out."
                )
            ),
            intermediateScenarios = listOf(
                LondonScenario(
                    id = "house_int_1",
                    title = "Negotiating rent increase",
                    level = "Intermediate",
                    situation = "Your landlord has proposed a rent increase of £150 per month to renew your tenancy.",
                    goal = "Write or speak to your landlord proposing a smaller, more reasonable increase of £50, citing market rates.",
                    starterPhrase = "We love living here, but a monthly increase of £150 is quite steep. Would you consider £50 instead?",
                    localTip = "Check local listing sites (Rightmove/Zoopla) to gather evidence of comparable rents in your immediate area."
                ),
                LondonScenario(
                    id = "house_int_2",
                    title = "Reporting black mold",
                    level = "Intermediate",
                    situation = "You have noticed persistent black damp and mold forming on the walls of your bedroom window frame.",
                    goal = "Explain the problem to your landlord, noting that you ventilate the room daily, and request a professional survey.",
                    starterPhrase = "There is persistent black mold forming in the bedroom. I open the windows daily, but it seems to be a structural damp issue.",
                    localTip = "Damp and mold are major issues in older Victorian brick conversions in London during winter months."
                ),
                LondonScenario(
                    id = "house_int_3",
                    title = "Inquiring about tenancy deposit protection",
                    level = "Intermediate",
                    situation = "You paid a deposit of five weeks' rent, but you haven't received confirmation that it has been registered in a government scheme.",
                    goal = "Ask your letting agent for the official registration certificate of your security deposit.",
                    starterPhrase = "Could you please provide the registration certificate showing that my security deposit is protected in an government-approved scheme?",
                    localTip = "By law, landlords must register your tenancy deposit in a registered scheme (like TDS or DPS) within 30 days."
                ),
                LondonScenario(
                    id = "house_int_4",
                    title = "Asking for a reference letter",
                    level = "Intermediate",
                    situation = "You are preparing to move to a new flat and the new agency requires a positive reference from your current landlord.",
                    goal = "Send a polite request to your landlord asking if they can provide a written reference confirming you paid rent on time.",
                    starterPhrase = "As we are moving to a new flat next month, would you mind providing a brief landlord reference confirming our rental history?",
                    localTip = "Having a clean reference from a previous UK landlord is a massive advantage when applying for competitive flats."
                ),
                LondonScenario(
                    id = "house_int_5",
                    title = "Discussing the break clause",
                    level = "Intermediate",
                    situation = "You are reviewing a proposed 12-month tenancy agreement and want to ensure there is a break clause at month six.",
                    goal = "Ask the letting agent to insert a standard 6-month break clause into the contract terms.",
                    starterPhrase = "Before signing, is it possible to insert a standard six-month mutual break clause into this tenancy agreement?",
                    localTip = "A break clause allows either the tenant or landlord to end the tenancy early after giving a specified notice period."
                )
            ),
            advancedScenarios = listOf(
                LondonScenario(
                    id = "house_adv_1",
                    title = "Deposit dispute negotiations",
                    level = "Advanced",
                    situation = "Your tenancy has ended, and your landlord wants to deduct £400 from your deposit for professional cleaning and minor wall scuffs.",
                    goal = "Construct a firm, detailed rebuttal arguing that wall scuffs fall under 'fair wear and tear' and provide cleaning receipts as counter-proof.",
                    starterPhrase = "We dispute the proposed £400 deduction. The minor scuffs constitute fair wear and tear under TDS guidelines, and we have professional cleaning receipts.",
                    localTip = "Under UK law, landlords cannot claim deductions for 'fair wear and tear'. You can dispute unfair deductions for free via your deposit scheme's ADR (Alternative Dispute Resolution)."
                ),
                LondonScenario(
                    id = "house_adv_2",
                    title = "Addressing emergency boiler breakdown",
                    level = "Advanced",
                    situation = "It is freezing winter, and your combi boiler has broken down entirely, leaving you with no heating or hot water for three days.",
                    goal = "Contact your landlord or letting agent to state that this constitutes an emergency hazard, and demand an immediate plumber under tenant safety regulations.",
                    starterPhrase = "We have been without heating or hot water for three days in freezing temperatures. This is an urgent emergency, and we expect a plumber today.",
                    localTip = "Landlords are required to resolve emergency heating failures within 24 hours during winter. If they fail, contact your local council's environmental health team."
                ),
                LondonScenario(
                    id = "house_adv_3",
                    title = "Subletting permission request",
                    level = "Advanced",
                    situation = "You have a spare bedroom in your rented flat and want to ask your landlord for formal permission to take on a lodger.",
                    goal = "Write a comprehensive proposal explaining how you will vet the candidate and asking for formal written consent to amend the tenancy agreement.",
                    starterPhrase = "We would like to request permission to take on a lodger for the spare room. We will ensure they are fully vetted and can add an addendum to our contract.",
                    localTip = "Standard tenancy agreements strictly forbid subletting without the landlord's prior written consent, which cannot be unreasonably withheld."
                ),
                LondonScenario(
                    id = "house_adv_4",
                    title = "Handling illegal landlord entry",
                    level = "Advanced",
                    situation = "Your landlord entered your flat yesterday without giving any warning or notice, which violated your right to 'quiet enjoyment'.",
                    goal = "Draft a polite but legally firm email reminding the landlord of the statutory 24-hour notice requirement.",
                    starterPhrase = "We noticed someone entered the flat yesterday without prior notice. As a reminder, we require at least 24 hours' notice before any visits, except in emergencies.",
                    localTip = "Except in emergencies, landlords must give at least 24 hours' written notice and obtain your consent before entering your home."
                ),
                LondonScenario(
                    id = "house_adv_5",
                    title = "Negotiating lease surrender",
                    level = "Advanced",
                    situation = "You need to relocate abroad immediately for a new job, but you still have four months left on your fixed-term tenancy with no break clause.",
                    goal = "Approach your landlord to negotiate a mutual early surrender of the tenancy, offering to help find a replacement tenant.",
                    starterPhrase = "Due to an unexpected job relocation abroad, I'd like to request an early surrender of my tenancy and would be happy to cover advertising costs for a replacement.",
                    localTip = "If there is no break clause, you are legally liable for the rent until the lease ends unless the landlord agrees to a surrender or a replacement tenant is found."
                )
            ),
            usefulPhrases = listOf(
                UsefulPhrase("Is there a break clause?", "Does the contract allow either party to end the tenancy early?", "Negotiating tenancy terms."),
                UsefulPhrase("The boiler is making a loud noise.", "The heating system seems to have a technical malfunction.", "Reporting a repair issue."),
                UsefulPhrase("Does this include Council Tax?", "Is the local municipal tax covered in the monthly rent figure?", "Inquiring about utility bills."),
                UsefulPhrase("When is the deposit protection certificate sent?", "When will I receive official proof that my deposit is held securely?", "After signing a tenancy."),
                UsefulPhrase("I'd like to book a viewing.", "I want to schedule a time to inspect the advertised property.", "Calling a letting agency.")
            ),
            commonMistakes = listOf(
                CommonMistake("I want to lease an apartment.", "I'd like to rent a flat.", "In the UK, residential properties are called 'flats', not 'apartments', and the action is 'renting', not 'leasing'."),
                CommonMistake("We need to fix the heating machine.", "We need to fix the boiler.", "British homes almost always use central heating powered by a 'boiler', never referred to as a 'heating machine'."),
                CommonMistake("The landlord entered my apartment illegally.", "The landlord entered my flat without notice.", "Avoid dramatic legal threats initially. Refer calmly to 'failing to provide 24 hours' written notice'."),
                CommonMistake("I want my deposit money back now.", "I'd like to request my deposit refund through the protection scheme.", "Deposits are held in official schemes. You must request them formally through the TDP scheme, not directly in cash."),
                CommonMistake("The rent is too expensive.", "The rental rate is slightly above local market averages.", "Use polite understatement ('slightly above market average') to negotiate rent reductions rather than calling it 'too expensive'.")
            ),
            localExpressions = listOf(
                LocalExpression("Flat", "An apartment or residential suite.", "We are looking for a two-bedroom flat in North London."),
                LocalExpression("Boiler", "The household furnace heating water for radiators.", "The boiler broke down, so we have no heating tonight."),
                LocalExpression("Council Tax", "Local tax paid to the municipal borough.", "How much is the Council Tax band for this property?"),
                LocalExpression("Tenancy Deposit Scheme", "Government-approved scheme protecting security deposits.", "My deposit is held securely in the Tenancy Deposit Scheme."),
                LocalExpression("Letting agent", "Real estate broker managing rentals.", "The letting agent will meet us outside the flat for the viewing.")
            )
        ),

        // Category 4: Work and manager conversations
        LondonCategoryPack(
            categoryId = "work_manager",
            categoryName = "Work and manager conversations",
            icon = "💼",
            beginnerScenarios = listOf(
                LondonScenario(
                    id = "work_beg_1",
                    title = "Requesting annual leave",
                    level = "Beginner",
                    situation = "You want to book three days off work next month to visit family.",
                    goal = "Ask your line manager if those dates are free for you to take annual leave.",
                    starterPhrase = "Hi, I was hoping to take three days of annual leave next month, from the 12th to the 14th. Would that be alright?",
                    localTip = "In the UK, holiday allowance is called 'annual leave' or 'holiday', never 'vacation'."
                ),
                LondonScenario(
                    id = "work_beg_2",
                    title = "Calling in sick",
                    level = "Beginner",
                    situation = "You woke up with severe stomach flu and are unable to log in or work today.",
                    goal = "Message your manager as early as possible to explain that you are calling in sick today.",
                    starterPhrase = "Good morning, I'm really sorry, but I woke up feeling very unwell today and need to call in sick.",
                    localTip = "Under UK employment rules, you do not need to provide a doctor's note if you are sick for seven days or less; you can 'self-certify'."
                ),
                LondonScenario(
                    id = "work_beg_3",
                    title = "Asking for task feedback",
                    level = "Beginner",
                    situation = "You have finished drafting a weekly report and want to confirm it is what your manager wanted.",
                    goal = "Send a brief note asking your manager to review the draft when they have a spare moment.",
                    starterPhrase = "Hi, I've finished the draft report. Could you have a quick look when you get a moment to check if it's what you need?",
                    localTip = "British managers appreciate a collaborative, polite approach. Using soft phrasings like 'when you get a moment' is very common."
                ),
                LondonScenario(
                    id = "work_beg_4",
                    title = "Running late for a meeting",
                    level = "Beginner",
                    situation = "Your bus is stuck in heavy traffic on the high street, and you will be ten minutes late for the team meeting.",
                    goal = "Send a message to your team or manager apologizing for the delay and explaining the cause.",
                    starterPhrase = "So sorry, my bus is stuck in traffic, so I might be about ten minutes late for our stand-up.",
                    localTip = "A quick heads-up is highly appreciated in London corporate culture to keep schedules running smoothly."
                ),
                LondonScenario(
                    id = "work_beg_5",
                    title = "Confirming work hours",
                    level = "Beginner",
                    situation = "You are starting a new office job and want to double-check the standard daily working hours.",
                    goal = "Ask HR or your team lead what the typical start and finish times are for the London office.",
                    starterPhrase = "Could you please confirm the typical working hours for our office? Is it standard nine-to-five?",
                    localTip = "While 'nine-to-five' is a common phrase, many London offices offer flexible start times between 8:00 AM and 10:00 AM."
                )
            ),
            intermediateScenarios = listOf(
                LondonScenario(
                    id = "work_int_1",
                    title = "Reporting project delays",
                    level = "Intermediate",
                    situation = "An external contractor has delayed sending their database layout, pushing back your timeline by two days.",
                    goal = "Explain the delay to your manager, explain the mitigation steps, and propose a rescheduled delivery date.",
                    starterPhrase = "We've hit a slight bottleneck as we're still waiting on the database layouts, which might push our deadline back by two days.",
                    localTip = "Use corporate understatements like 'hit a slight bottleneck' or 'minor delay' rather than sounding panicked."
                ),
                LondonScenario(
                    id = "work_int_2",
                    title = "Asking for a 1-to-1 catchup",
                    level = "Intermediate",
                    situation = "You want to discuss your career progression and training options with your manager outside of daily project stand-ups.",
                    goal = "Request a dedicated 30-minute 1-to-1 meeting in your manager's calendar next week.",
                    starterPhrase = "Hi, do you have twenty minutes to spare next week for a quick one-to-one? I'd love to chat about my training goals.",
                    localTip = "Regular 'one-to-ones' (1:1s) are a standard part of UK office culture to monitor progress and support staff."
                ),
                LondonScenario(
                    id = "work_int_3",
                    title = "Negotiating hybrid working days",
                    level = "Intermediate",
                    situation = "Your company allows two days of working from home (WFH), and you want to request specific days to accommodate child care or commute costs.",
                    goal = "Propose working from home on Tuesdays and Thursdays to balance office collaboration and personal commitments.",
                    starterPhrase = "Would it be possible for me to work from home on Tuesdays and Thursdays? I find those days best for deep-focus work.",
                    localTip = "Hybrid working is extremely popular in London. Frame your request around productivity and focus."
                ),
                LondonScenario(
                    id = "work_int_4",
                    title = "Handling client feedback clash",
                    level = "Intermediate",
                    situation = "A client has sent highly critical, slightly rude feedback on a design layout you delivered.",
                    goal = "Discuss the feedback with your manager, defend your design choices professionally, and agree on a response strategy.",
                    starterPhrase = "The client has raised some concerns about the layout. While I understand their point, our current design is optimized for mobile users.",
                    localTip = "Collaborative problem-solving with your manager is key. Focus on objective metrics and professional solutions."
                ),
                LondonScenario(
                    id = "work_int_5",
                    title = "Requesting training budget",
                    level = "Intermediate",
                    situation = "You found an industry-recognized project management certification course costing £600.",
                    goal = "Present the business benefits of this course to your manager and ask if the company can sponsor it.",
                    starterPhrase = "I've found a project management course that would really help me streamline our sprint planning. Is there any training budget available to cover this?",
                    localTip = "Show how the training directly benefits the business or the immediate team's performance."
                )
            ),
            advancedScenarios = listOf(
                LondonScenario(
                    id = "work_adv_1",
                    title = "Negotiating a pay rise",
                    level = "Advanced",
                    situation = "You have been with your company for 18 months, taken on additional team leadership duties, and want to discuss a salary review.",
                    goal = "Prepare a structured, professional pitch highlighting your key accomplishments and request a 10% salary adjustment.",
                    starterPhrase = "Given the expansion of my responsibilities and the successful delivery of our recent campaigns, I'd like to request a formal salary review.",
                    localTip = "UK salary negotiations should always be structured around clear, measurable achievements and professional value rather than personal expenses."
                ),
                LondonScenario(
                    id = "work_adv_2",
                    title = "Addressing workplace burnout",
                    level = "Advanced",
                    situation = "Due to staff shortages, you have been working 60-hour weeks for two months and are experiencing symptoms of physical exhaustion and burnout.",
                    goal = "Discuss your workload boundary concerns with your manager, proposing a temporary freeze on new tasks or adding contract support.",
                    starterPhrase = "I need to raise a concern about my current workload. The sustained 60-hour weeks are becoming unsustainable, and I're concerned about the impact on quality.",
                    localTip = "UK employers have a legal duty of care to protect staff health and safety. Frame burnout around long-term sustainability and quality."
                ),
                LondonScenario(
                    id = "work_adv_3",
                    title = "Delivering constructive feedback to peer",
                    level = "Advanced",
                    situation = "A colleague on your project team is repeatedly failing to update their JIRA tickets, causing miscommunication during sprints.",
                    goal = "Speak to them privately using constructive 'sandwich feedback' techniques to encourage consistent updates without causing offense.",
                    starterPhrase = "You've been doing great work on the codebase. However, it would really help the team if you could update the JIRA tickets more regularly.",
                    localTip = "The 'feedback sandwich' (compliment, critique, compliment) is widely used in British management to preserve positive peer relationships."
                ),
                LondonScenario(
                    id = "work_adv_4",
                    title = "Managing a project crisis",
                    level = "Advanced",
                    situation = "A critical bug has leaked into production, taking down the payment gateway for 15% of active users.",
                    goal = "Brief your executive director on the incident, explain the root cause, outline the patch deployment plan, and manage their anxiety calmly.",
                    starterPhrase = "We have identified a database regression affecting 15% of payment transactions. The engineering team is deploying a hotfix, and we expect resolution within forty minutes.",
                    localTip = "During a live incident, executives value calm clarity, precise timeframes, and confirmation that a fix is actively being deployed."
                ),
                LondonScenario(
                    id = "work_adv_5",
                    title = "Proposing a major structural pivot",
                    level = "Advanced",
                    situation = "You believe the team's current manual QA testing pipeline should be completely replaced by an automated testing framework.",
                    goal = "Present a high-level strategic argument to your manager contrasting long-term cost savings, speed, and quality upgrades.",
                    starterPhrase = "I'd like to propose a strategic shift from manual QA to automated testing. Although it requires upfront investment, it will cut our regression cycle by seventy percent.",
                    localTip = "Support major proposals with brief cost-benefit calculations and a clear transition pathway."
                )
            ),
            usefulPhrases = listOf(
                UsefulPhrase("Could we schedule a quick catchup?", "I'd like to book some time in your calendar to check in on progress.", "Requesting a meeting with a manager."),
                UsefulPhrase("I have a slight bottleneck here.", "I am experiencing a minor delay due to external factors.", "Explaining work blockages."),
                UsefulPhrase("I'd like to take annual leave.", "I want to request some of my holiday allowance days off.", "Asking for holiday booking."),
                UsefulPhrase("Let's circles back to this later.", "Let's return to this topic during our next discussion.", "Postponing a discussion topic."),
                UsefulPhrase("I'll take ownership of that.", "I will be responsible for completing this specific task.", "Accepting action items in a meeting.")
            ),
            commonMistakes = listOf(
                CommonMistake("I want to take a vacation.", "I'd like to book some annual leave.", "In British professional settings, refer to time off as 'annual leave' or 'holiday', never 'vacation'."),
                CommonMistake("I'm sick today. I can't come.", "I'm calling in sick today as I'm feeling quite unwell.", "Saying 'I can't come' sounds slightly childish. Use the professional phrasal verb 'calling in sick'."),
                CommonMistake("I did a mistake in the report.", "I've noticed a minor oversight in the report.", "Acknowledge mistakes professionally by referring to them as 'oversights', 'omissions', or 'slight errors' rather than flatly calling it a 'mistake'."),
                CommonMistake("Give me a feedback on my work.", "Could you provide some feedback on my work when you have a moment?", "'Feedback' is uncountable; saying 'a feedback' is grammatically incorrect. Use soft requests with 'some feedback'."),
                CommonMistake("I am very busy with tasks.", "My capacity is currently quite stretched.", "Saying 'I am busy' can sound slightly dismissive. A more polished corporate phrase is 'my capacity is currently quite stretched'.")
            ),
            localExpressions = listOf(
                LocalExpression("Annual leave", "Paid holiday allowance from work.", "I have ten days of annual leave left to take this year."),
                LocalExpression("One-to-one", "Regular private catchup meeting with a manager.", "I'll discuss my salary review during our next one-to-one."),
                LocalExpression("Bottleneck", "A blockage or delay in a workflow process.", "The design team is our main bottleneck at the moment."),
                LocalExpression("Calling in sick", "Notifying your employer you are too ill to work.", "I had to call in sick this morning due to a bad stomach flu."),
                LocalExpression("Circles back", "To return to a topic or follow up later.", "Let's circle back to this once we have the client's feedback.")
            )
        ),

        // Category 5: Retail and customer service
        LondonCategoryPack(
            categoryId = "retail_customer",
            categoryName = "Retail and customer service",
            icon = "🛍️",
            beginnerScenarios = listOf(
                LondonScenario(
                    id = "ret_beg_1",
                    title = "Asking for a receipt",
                    level = "Beginner",
                    situation = "You have just paid for some clothes at a department store and want to make sure you have a physical receipt.",
                    goal = "Politely request a printed receipt from the cashier.",
                    starterPhrase = "Could I please have a paper receipt for this transaction?",
                    localTip = "Many London shops default to emailing receipts now to save paper, so specify if you need a physical printout."
                ),
                LondonScenario(
                    id = "ret_beg_2",
                    title = "Checking stock availability",
                    level = "Beginner",
                    situation = "You see a jacket on display, but you cannot find your size on the clothes rack.",
                    goal = "Ask a shop assistant if they have a medium size available in the stockroom.",
                    starterPhrase = "Excuse me, do you have this jacket in a medium size in stock?",
                    localTip = "Shop assistants can easily scan the barcode on their store devices to check stock in nearby branches."
                ),
                LondonScenario(
                    id = "ret_beg_3",
                    title = "Asking for the changing rooms",
                    level = "Beginner",
                    situation = "You have picked out two shirts to try on and need to locate the fitting rooms inside the store.",
                    goal = "Ask an assistant on the shop floor where the changing rooms are located.",
                    starterPhrase = "Hi there, could you tell me where the changing rooms are, please?",
                    localTip = "Changing rooms are often referred to as 'fitting rooms' or 'changing cubicles' in UK retail."
                ),
                LondonScenario(
                    id = "ret_beg_4",
                    title = "Asking about return windows",
                    level = "Beginner",
                    situation = "You are buying a gift for a friend and want to know how many days they have to return or exchange it.",
                    goal = "Ask the cashier about the store's standard refund and exchange period.",
                    starterPhrase = "What is your standard return policy for exchanges or refunds on this item?",
                    localTip = "UK statutory rights guarantee refunds for online purchases, but physical stores can set their own return windows (usually 14 or 28 days)."
                ),
                LondonScenario(
                    id = "ret_beg_5",
                    title = "Inquiring about card payments",
                    level = "Beginner",
                    situation = "You want to buy a bottle of water at a small corner shop (off-licence) and want to know if they accept contactless cards.",
                    goal = "Ask the shopkeeper if there is a minimum spend limit for card payments.",
                    starterPhrase = "Do you accept card payments for under five pounds, or is there a minimum spend?",
                    localTip = "While almost all London shops are cashless, a few small newsagents still enforce a £3 or £5 minimum spend for cards."
                )
            ),
            intermediateScenarios = listOf(
                LondonScenario(
                    id = "ret_int_1",
                    title = "Exchanging a damaged item",
                    level = "Intermediate",
                    situation = "You bought a toaster yesterday, but when you unpacked it at home, you noticed a large dent on the metal side.",
                    goal = "Return to the store, explain the defect, and request a direct exchange for a brand-new unit.",
                    starterPhrase = "I bought this toaster yesterday, but upon unpacking it, I noticed there's a significant dent on the side. Could I exchange it for a new one?",
                    localTip = "Ensure you bring your paper receipt or digital transaction proof to avoid exchange disputes."
                ),
                LondonScenario(
                    id = "ret_int_2",
                    title = "Applying a discount code",
                    level = "Intermediate",
                    situation = "You are purchasing items online and your student or promotional discount code is showing an error at checkout.",
                    goal = "Contact live chat customer service to explain the error and ask them to apply the 10% discount manually.",
                    starterPhrase = "My promotional discount code is showing an error at checkout, even though it should still be valid. Could you look into this?",
                    localTip = "Many UK brands offer student discounts via third-party verification portals like UNiDAYS or Student Beans."
                ),
                LondonScenario(
                    id = "ret_int_3",
                    title = "Inquiring about home delivery",
                    level = "Intermediate",
                    situation = "You want to buy a large bookshelf, but it is too heavy to carry home on the Tube.",
                    goal = "Ask the store assistant about flat-rate home delivery options, delivery windows, and assembly services.",
                    starterPhrase = "Do you offer a home delivery service for larger furniture pieces, and if so, how much does it cost?",
                    localTip = "Large stores like IKEA or John Lewis offer delivery, but scheduling slot times can take several days."
                ),
                LondonScenario(
                    id = "ret_int_4",
                    title = "Tracking a missing package",
                    level = "Intermediate",
                    situation = "Your online clothing order was marked as 'delivered' by Evri or Royal Mail, but you never received it.",
                    goal = "Call customer support to explain that the package is missing and request a replacement or investigation.",
                    starterPhrase = "My tracking says the parcel was delivered yesterday, but I haven't received anything. Could you open an investigation?",
                    localTip = "Evri and Royal Mail are the primary parcel couriers in London; 'safe space' delivery errors are common."
                ),
                LondonScenario(
                    id = "ret_int_5",
                    title = "Asking about price matching",
                    level = "Intermediate",
                    situation = "You see an electronics item in Currys, but a competitor website has it listed for £30 cheaper.",
                    goal = "Ask the store supervisor if they have a price-matching policy that covers online UK retailers.",
                    starterPhrase = "I've seen this exact model listed for thirty pounds less on another major UK retailer's site. Do you offer price matching?",
                    localTip = "Department stores like John Lewis are famous for price matching, though they require the competitor to have stock available."
                )
            ),
            advancedScenarios = listOf(
                LondonScenario(
                    id = "ret_adv_1",
                    title = "Asserting statutory rights",
                    level = "Advanced",
                    situation = "A high-end winter coat you bought three months ago has developed a massive tear in the inner lining due to poor stitching.",
                    goal = "Speak to the store manager to assert your rights under the Consumer Rights Act 2015, demanding a repair or refund rather than store credit.",
                    starterPhrase = "Under the Consumer Rights Act 2015, this tear within three months is a manufacturing fault, so I'm entitled to a repair or refund.",
                    localTip = "Under the Consumer Rights Act, goods must be of satisfactory quality, fit for purpose, and last a reasonable length of time."
                ),
                LondonScenario(
                    id = "ret_adv_2",
                    title = "Resolving a delivery billing error",
                    level = "Advanced",
                    situation = "An online furniture company charged your credit card twice for a dining table delivery, and their automated email helpdesk is ignoring your tickets.",
                    goal = "Call their customer escalation line to explain the duplicate charge, cite transaction IDs, and demand immediate financial reversal.",
                    starterPhrase = "I am calling to escalate a billing issue. My credit card has been charged twice for transaction reference 49201, and my helpdesk tickets have gone unanswered.",
                    localTip = "Mentioning a 'credit card chargeback' or 'raising a dispute with my bank' usually accelerates customer service responses."
                ),
                LondonScenario(
                    id = "ret_adv_3",
                    title = "Dealing with rude service",
                    level = "Advanced",
                    situation = "A restaurant waiter was extremely dismissive, roll-eyed when you asked about gluten-free options, and charged an automatic 12.5% service charge anyway.",
                    goal = "Politely but firmly request the manager to remove the optional service charge from the final bill and explain why.",
                    starterPhrase = "We would like to request that the twelve point five percent service charge be removed from our bill, as we found the table service quite dismissive today.",
                    localTip = "In London restaurants, a 12.5% service charge is almost always added automatically, but it is legally optional, and you have the right to ask for its removal."
                ),
                LondonScenario(
                    id = "ret_adv_4",
                    title = "Claiming VAT refund",
                    level = "Advanced",
                    situation = "You are a non-UK resident returning home soon and want to claim a tax refund on several luxury goods purchased in London.",
                    goal = "Ask the customer service desk manager about the paperwork and current post-Brexit regulations for VAT retail export schemes.",
                    starterPhrase = "Could you please explain the current procedure for claiming a tax refund on these luxury goods as a non-UK resident?",
                    localTip = "Direct tax-free shopping in shops was largely abolished post-Brexit, but some refund schemes exist for items shipped directly to international addresses."
                ),
                LondonScenario(
                    id = "ret_adv_5",
                    title = "Negotiating bulk purchase discount",
                    level = "Advanced",
                    situation = "You are buying ten high-end office chairs for your team from a local independent commercial retailer.",
                    goal = "Propose a 15% volume discount or free white-glove assembly service to close the deal.",
                    starterPhrase = "Since we are purchasing ten of these units today, is there any scope for a volume discount, or perhaps including free assembly?",
                    localTip = "Independent UK retailers often have flexibility on pricing for business accounts or bulk orders."
                )
            ),
            usefulPhrases = listOf(
                UsefulPhrase("Could I get a receipt, please?", "I need written confirmation of this financial purchase.", "At the retail cash register."),
                UsefulPhrase("Is this item returnable?", "Am I eligible to refund this product if I change my mind?", "Inquiring about store return policies."),
                UsefulPhrase("Do you have this in stock?", "Is there additional inventory of this product in the back room?", "Asking a store assistant."),
                UsefulPhrase("Is there an optional service charge?", "Is the tip already added to the bill, and do I have to pay it?", "Reviewing a restaurant bill."),
                UsefulPhrase("Could I speak to the manager?", "I need to escalate an unresolved issue to a senior employee.", "Handling a customer dispute.")
            ),
            commonMistakes = listOf(
                CommonMistake("I want to return this, give me cash.", "I'd like to return this for a refund, please.", "Direct demands sound aggressive. Frame returns politely using 'I'd like to request a refund'."),
                CommonMistake("The price is too expensive here.", "This item is priced slightly higher than elsewhere.", "Avoid calling prices 'expensive' directly to staff. Refer to competitor comparison or ask about price matching policies."),
                CommonMistake("Do you accept bills?", "Do you accept cash?", "In the UK, paper currency notes are called 'cash' or 'notes', never 'bills' (which refers to restaurant invoices or utility charges)."),
                CommonMistake("Where is the checkout stand?", "Where are the tills / cash desk?", "In the UK, retail checkout counters are commonly called 'the tills' or 'cash desk', rather than 'checkout stands'."),
                CommonMistake("The delivery was broken.", "The item arrived damaged in transit.", "Saying 'delivery was broken' is slightly awkward. Refer to 'damaged in transit' or 'defective upon unpacking'.")
            ),
            localExpressions = listOf(
                LocalExpression("Tills", "The cash registers or checkout counters in a shop.", "I'll pay for these shirts at the tills on the ground floor."),
                LocalExpression("Evri / Royal Mail", "The primary courier and postal services in the UK.", "My package is being delivered by Evri, hopefully it arrives today."),
                LocalExpression("Service charge", "An optional service tip added automatically to restaurant bills.", "The service charge is already included in our restaurant total."),
                LocalExpression("Fitting rooms", "Changing rooms inside a clothing store.", "The fitting rooms are located past the shoe department."),
                LocalExpression("Off-licence", "A small convenience shop selling alcohol and snacks.", "I'll pop into the off-licence to buy a bottle of fizzy water.")
            )
        ),

        // Category 6: Job interviews
        LondonCategoryPack(
            categoryId = "job_interviews",
            categoryName = "Job interviews",
            icon = "👔",
            beginnerScenarios = listOf(
                LondonScenario(
                    id = "int_beg_1",
                    title = "Greeting the interviewer",
                    level = "Beginner",
                    situation = "You are arriving at a London office building for a face-to-face job interview.",
                    goal = "Introduce yourself to the receptionist, state your appointment time, and the name of the interviewer.",
                    starterPhrase = "Hello, my name is Alex. I'm here for a job interview with Sarah Jenkins at ten AM.",
                    localTip = "Arriving 10-15 minutes early is standard. Security desks in corporate buildings (especially in the City or Canary Wharf) require photo ID."
                ),
                LondonScenario(
                    id = "int_beg_2",
                    title = "Talking about work experience",
                    level = "Beginner",
                    situation = "The interviewer asks you the classic opening question: 'Tell me about yourself.'",
                    goal = "Provide a simple, 3-sentence summary of your professional background and main skills.",
                    starterPhrase = "I have over three years of experience working in customer support, where I specialized in resolving complex technical queries.",
                    localTip = "Keep this opening summary high-level, positive, and directly linked to the role you are applying for."
                ),
                LondonScenario(
                    id = "int_beg_3",
                    title = "Asking about next steps",
                    level = "Beginner",
                    situation = "The interview has finished, and the panel asks if you have any questions for them.",
                    goal = "Ask when they expect to make a decision and what the next stages of the hiring process look like.",
                    starterPhrase = "Thank you for your time today. Could you tell me what the next stages of the hiring process look like?",
                    localTip = "Asking about next steps shows enthusiasm and helps you manage your follow-up timeline."
                ),
                LondonScenario(
                    id = "int_beg_4",
                    title = "Answering salary range questions",
                    level = "Beginner",
                    situation = "The interviewer asks what your salary expectations are for this role.",
                    goal = "Politely state a competitive target salary range based on market rates.",
                    starterPhrase = "Based on my research and experience in similar London roles, I'm looking for a salary in the range of forty to forty-five thousand pounds.",
                    localTip = "Always check sites like Glassdoor or LinkedIn to find average salary benchmarks for London."
                ),
                LondonScenario(
                    id = "int_beg_5",
                    title = "Explaining employment gaps",
                    level = "Beginner",
                    situation = "The interviewer notices a 6-month gap on your CV and asks about it.",
                    goal = "Briefly explain the gap positively as time spent traveling or doing professional training.",
                    starterPhrase = "During that period, I took some time off to undertake intensive training in software development and complete several personal projects.",
                    localTip = "Frame any career breaks as productive intervals for learning, family care, or structured relocation planning."
                )
            ),
            intermediateScenarios = listOf(
                LondonScenario(
                    id = "int_int_1",
                    title = "Describing professional strengths",
                    level = "Intermediate",
                    situation = "The interviewer asks: 'Why should we hire you over other candidates?'",
                    goal = "Deliver a confident pitch matching your project delivery skills to their current business growth challenges.",
                    starterPhrase = "You should hire me because I have a proven track record of cutting deployment cycles, which aligns perfectly with your goal to scale this quarter.",
                    localTip = "Focus on what value you bring to the team rather than just describing your generic qualities."
                ),
                LondonScenario(
                    id = "int_int_2",
                    title = "STAR method conflict explanation",
                    level = "Intermediate",
                    situation = "The interviewer asks: 'Tell me about a time you disagreed with a colleague.'",
                    goal = "Explain a professional disagreement using the STAR method (Situation, Task, Action, Result), highlighting a collaborative resolution.",
                    starterPhrase = "In my last role, we had a disagreement over a project deadline. I organized a data review session, which helped us compromise on a phased release.",
                    localTip = "The STAR method is the industry standard for competency-based interviews in the UK. Keep actions focused on your contribution."
                ),
                LondonScenario(
                    id = "int_int_3",
                    title = "Explaining why leaving current job",
                    level = "Intermediate",
                    situation = "The interviewer asks: 'Why do you want to leave your current employer?'",
                    goal = "Explain your reasons positively, framing them around a desire for greater scope, learning, and new challenges.",
                    starterPhrase = "While I've learned a lot in my current role, I'm looking for a new challenge that allows me to lead larger engineering projects.",
                    localTip = "Never criticize your previous employer, manager, or colleagues. Keep explanations strictly positive and future-focused."
                ),
                LondonScenario(
                    id = "int_int_4",
                    title = "Asking intelligent business questions",
                    level = "Intermediate",
                    situation = "The interviewer asks: 'Do you have any questions for us?'",
                    goal = "Ask an insightful question about team culture, department challenges, or company strategy.",
                    starterPhrase = "What is the biggest challenge the engineering team is currently facing, and how can the person in this role help resolve it?",
                    localTip = "Avoid asking about salary, benefits, or holiday during the first round of interviews. Focus on the work itself."
                ),
                LondonScenario(
                    id = "int_int_5",
                    title = "Handling tech test review",
                    level = "Intermediate",
                    situation = "You are presenting a technical task or coding challenge you submitted prior to the interview.",
                    goal = "Walk through your design architecture, explain any trade-offs you made, and suggest how you would improve it with more time.",
                    starterPhrase = "For this task, I prioritized database query optimization. Given more time, I would expand the automated unit test coverage.",
                    localTip = "UK tech companies value humility and self-awareness. Acknowledging trade-offs and future improvements is highly respected."
                )
            ),
            advancedScenarios = listOf(
                LondonScenario(
                    id = "int_adv_1",
                    title = "Discussing strategic business vision",
                    level = "Advanced",
                    situation = "You are interviewing for a senior lead role, and the panel asks how you would handle team scaling under tight budget constraints.",
                    goal = "Present a structured, professional strategy balancing automation, outsourcing, and mentoring programs to sustain quality.",
                    starterPhrase = "To scale effectively under budget constraints, I would focus on automating regression pipelines while establishing peer-mentorship programs.",
                    localTip = "Senior interviews require you to talk about business outcomes, cost-efficiency, and long-term organizational health."
                ),
                LondonScenario(
                    id = "int_adv_2",
                    title = "Navigating salary negotiation",
                    level = "Advanced",
                    situation = "The HR director has called you with an official job offer, but the base salary is £5,000 below your expectations.",
                    goal = "Politely thank them for the offer, negotiate for a higher base salary, and suggest flexibility on performance-based bonuses.",
                    starterPhrase = "Thank you so much for the offer. While I'm incredibly excited to join, I was hoping we could get closer to fifty-five thousand based on my lead experience.",
                    localTip = "Keep the conversation warm and collaborative. Always frame negotiations around excitement to join the business."
                ),
                LondonScenario(
                    id = "int_adv_3",
                    title = "Answering failure questions",
                    level = "Advanced",
                    situation = "The panel asks a tough question: 'What is your biggest professional failure, and what did you learn from it?'",
                    goal = "Describe a genuine project setback, take ownership of the mistake, and detail the systemic process improvements you implemented to prevent a recurrence.",
                    starterPhrase = "A major deployment failed in my previous team due to insufficient environment checks. I took ownership and implemented a pre-deployment verification protocol.",
                    localTip = "Interviewer's aren't looking for a fake weakness (e.g., 'I work too hard'). They want to see genuine accountability, learning, and resilience."
                ),
                LondonScenario(
                    id = "int_adv_4",
                    title = "Presenting a 30-60-90 day plan",
                    level = "Advanced",
                    situation = "You are pitching for a management role, and the interviewers ask how you plan to onboard and deliver value quickly.",
                    goal = "Present a structured 30-60-90 day plan focusing on listening, identifying quick wins, and implementing process improvements.",
                    starterPhrase = "In my first thirty days, I will audit our current pipeline and build alignment with key stakeholders before implementing any changes.",
                    localTip = "A successful 30-60-90 day plan starts with listening and auditing. Do not propose sweeping changes without understanding the context."
                ),
                LondonScenario(
                    id = "int_adv_5",
                    title = "Discussing company value alignment",
                    level = "Advanced",
                    situation = "The interviewer asks: 'How do our corporate values of transparency and customer empathy align with your work style?'",
                    goal = "Provide a high-fidelity explanation connecting a past team-leadership incident to their specific published values.",
                    starterPhrase = "Customer empathy is central to my work style. For instance, I always run user-testing sessions myself to understand their pain points.",
                    localTip = "Always research the company's website beforehand to find their core values and weave them into your answers naturally."
                )
            ),
            usefulPhrases = listOf(
                UsefulPhrase("Could you elaborate on the team dynamics?", "Could you tell me more about how the team collaborates daily?", "Inquiring about team structure during an interview."),
                UsefulPhrase("I'd like to highlight my experience with...", "I want to share my specific expertise in a relevant field.", "Focusing the conversation on a key skill."),
                UsefulPhrase("What are the key performance metrics?", "How will the success of the person in this role be measured?", "Asking about job expectations."),
                UsefulPhrase("I appreciate your detailed response.", "Thank you for providing a thorough explanation of my query.", "Polite transition after an answer."),
                UsefulPhrase("I'm very keen to contribute to...", "I am enthusiastic about bringing my skills to this company area.", "Expressing alignment with company goals.")
            ),
            commonMistakes = listOf(
                CommonMistake("I'm very perfect for this job.", "I believe my background makes me a strong fit for this role.", "Saying 'I am perfect' sounds boastful and lacks humility. Use standard UK phrases like 'strong fit for the role'."),
                CommonMistake("I left my job because my boss was bad.", "I am looking for a new opportunity that offers room for growth.", "Never criticize previous employers. It raises immediate red flags about your professionalism."),
                CommonMistake("My weakness is that I work too much.", "One area I'm actively developing is my public presentation style.", "Avoid cliché answers to the weakness question. Share a genuine, minor area of development and explain how you are improving it."),
                CommonMistake("I want a lot of money.", "I am looking for a salary that is competitive with current market rates.", "Direct demands for 'a lot of money' sound unprofessional. Frame salary discussions around 'market rates' and 'my level of experience'."),
                CommonMistake("Can you tell me your holiday policy?", "Could you share how employee development is supported here?", "Do not ask about holidays, sick pay, or benefits in the first interview. It suggests you are not interested in the actual work.")
            ),
            localExpressions = listOf(
                LocalExpression("STAR method", "Structured framework for answering behavioral interview questions.", "Make sure to structure your competency answers using the STAR method."),
                LocalExpression("Line manager", "Direct professional supervisor in a company.", "I'll be reporting directly to the engineering line manager."),
                LocalExpression("Hiring manager", "The manager responsible for making the final recruitment decision.", "The hiring manager will follow up with feedback by Friday."),
                LocalExpression("Notice period", "Contractual duration you must work after resigning.", "I have a standard one-month notice period at my current company."),
                LocalExpression("Glassdoor", "Job portal detailing employee reviews and average salaries.", "I checked Glassdoor to verify London salary averages for this role.")
            )
        ),

        // Category 7: Small talk and social life
        LondonCategoryPack(
            categoryId = "small_talk_social",
            categoryName = "Small talk and social life",
            icon = "🍻",
            beginnerScenarios = listOf(
                LondonScenario(
                    id = "soc_beg_1",
                    title = "Greeting someone at a pub",
                    level = "Beginner",
                    situation = "You are meeting a group of colleagues at a pub after work on a Friday evening.",
                    goal = "Greet them warmly, introduce yourself to any newcomers, and ask what they are drinking.",
                    starterPhrase = "Hi everyone! Good to see you. What's everyone having to drink?",
                    localTip = "Pub culture is central to London social life. It is standard to order drinks in 'rounds' at the bar."
                ),
                LondonScenario(
                    id = "soc_beg_2",
                    title = "Chatting about the weather",
                    level = "Beginner",
                    situation = "You are waiting for the Tube with a colleague, and it has suddenly started raining heavily.",
                    goal = "Initiate casual small talk about the sudden change in weather.",
                    starterPhrase = "Typical London weather, isn't it? It was completely sunny just five minutes ago!",
                    localTip = "Londoners love complaining about the weather. It is the absolute safest and most common icebreaker."
                ),
                LondonScenario(
                    id = "soc_beg_3",
                    title = "Asking about weekend plans",
                    level = "Beginner",
                    situation = "It is Friday afternoon, and you are finishing a coffee break with a coworker.",
                    goal = "Ask them if they have any interesting plans lined up for the weekend.",
                    starterPhrase = "Do you have any nice plans lined up for the weekend, or are you just having a quiet one?",
                    localTip = "Asking if someone is 'having a quiet one' is a very common, low-pressure way to query weekend plans."
                ),
                LondonScenario(
                    id = "soc_beg_4",
                    title = "Declining a drink politely",
                    level = "Beginner",
                    situation = "You are at a social event, and someone offers to buy you an alcoholic drink, but you do not drink alcohol or are driving.",
                    goal = "Politely decline the alcohol and request a soft drink instead.",
                    starterPhrase = "Thanks so much, but I'm not drinking tonight. I'd love a lime and soda if they have it, though!",
                    localTip = "'Lime and soda' is a very popular, cheap, and natural soft drink to order in British pubs."
                ),
                LondonScenario(
                    id = "soc_beg_5",
                    title = "Asking for a restaurant recommendation",
                    level = "Beginner",
                    situation = "You want to take a friend out for dinner in Soho and want to ask a colleague for a good spot.",
                    goal = "Ask your coworker if they know any good, reasonably priced restaurants in the area.",
                    starterPhrase = "Do you know any nice, reasonably priced Italian spots around Soho for a dinner with a friend?",
                    localTip = "Soho is famous for its dense food scene, but reservation-free spots often require waiting in long queues."
                )
            ),
            intermediateScenarios = listOf(
                LondonScenario(
                    id = "soc_int_1",
                    title = "Hosting someone for tea",
                    level = "Intermediate",
                    situation = "A neighbor has popped over to your flat to borrow a tool, and you want to host them warmly.",
                    goal = "Offer them a hot drink (tea or coffee), ask how they take it, and suggest a biscuit.",
                    starterPhrase = "Would you like a cuppa? I've got English Breakfast and Earl Grey on offer, or coffee if you prefer.",
                    localTip = "Offering a hot drink is a fundamental social reflex when anyone enters your home in the UK."
                ),
                LondonScenario(
                    id = "soc_int_2",
                    title = "Joining a social sports club",
                    level = "Intermediate",
                    situation = "You are calling or messaging a local mixed-tag rugby or tennis club to ask about joining.",
                    goal = "Inquire about membership costs, skill levels, and if they have casual social sessions for beginners.",
                    starterPhrase = "Hi, I'm looking to join your tag rugby club. Do you run any social sessions for complete beginners?",
                    localTip = "Joining social sports leagues (like Go Mammoth) is an incredibly popular way to make friends in London."
                ),
                LondonScenario(
                    id = "soc_int_3",
                    title = "Planning a group dinner",
                    level = "Intermediate",
                    situation = "You are organizing a birthday dinner for six friends and need to coordinate dates and dietary needs.",
                    goal = "Propose a couple of date options, ask about any allergies, and suggest a tapas restaurant.",
                    starterPhrase = "Hi everyone, I'm planning a dinner next week to celebrate my birthday. Do Thursday or Friday work best for you?",
                    localTip = "Always check for vegetarian, vegan, and gluten-free options, as Londoners have highly diverse dietary styles."
                ),
                LondonScenario(
                    id = "soc_int_4",
                    title = "Inviting a colleague for coffee",
                    level = "Intermediate",
                    situation = "You want to build a better working relationship with a new colleague in your department.",
                    goal = "Politely invite them for a 15-minute coffee walk to catch up on their first few weeks.",
                    starterPhrase = "Hi, I was going to pop out to grab a coffee from the café down the street. Would you like to come along for a quick break?",
                    localTip = "Coffee breaks are excellent low-pressure opportunities to connect with coworkers outside formal tasks."
                ),
                LondonScenario(
                    id = "soc_int_5",
                    title = "Discussing a book or movie",
                    level = "Intermediate",
                    situation = "You are discussing a popular new TV series or book during a lunch break with colleagues.",
                    goal = "Share your thoughts on the latest episode, ask what they thought, and avoid giving away major spoilers.",
                    starterPhrase = "Have you seen the latest episode of that new drama? I thought the ending was brilliant, but I won't spoil it!",
                    localTip = "British conversations often rely on shared media references. Acknowledging spoilers is considered highly polite."
                )
            ),
            advancedScenarios = listOf(
                LondonScenario(
                    id = "soc_adv_1",
                    title = "Navigating pub rounds etiquette",
                    level = "Advanced",
                    situation = "You are in a group of five at a pub, and you are discussing whose turn it is to buy the next round.",
                    goal = "Politely assert that it is your turn to buy the round, collect everyone's drink orders, and handle the transaction.",
                    starterPhrase = "Right, I think it's my round! What's everyone having? I'll head up to the bar.",
                    localTip = "Never skip your turn in a round; it is considered a major social faux pas in British pub etiquette."
                ),
                LondonScenario(
                    id = "soc_adv_2",
                    title = "Discussing British cultural nuances",
                    level = "Advanced",
                    situation = "You are explaining some of the differences between social interactions in your home country and London.",
                    goal = "Debate the concept of British 'polite distance' versus directness with a close friend over coffee.",
                    starterPhrase = "I've noticed that Londoners are incredibly polite but can sometimes be quite guarded compared to what I'm used to back home.",
                    localTip = "Londoners often appreciate discussing cultural observations if framed with warmth, curiosity, and good humor."
                ),
                LondonScenario(
                    id = "soc_adv_3",
                    title = "Organizing a large charity event",
                    level = "Advanced",
                    situation = "You are proposing a volunteer charity cleanup day for your company's London office.",
                    goal = "Present the charity proposal to the social committee, detailing logistics, transport, and community benefits.",
                    starterPhrase = "I'd like to propose a community volunteering day next month where we partner with a local South London park cleanup initiative.",
                    localTip = "UK companies often support 'Corporate Social Responsibility' (CSR) by giving employees dedicated volunteer days."
                ),
                LondonScenario(
                    id = "soc_adv_4",
                    title = "Politely exiting a boring conversation",
                    level = "Advanced",
                    situation = "You are trapped in an incredibly dry, long-winded conversation with a guest at a crowded networking event.",
                    goal = "Use a classic British polite excuse to disconnect warmly and move to another group without causing offense.",
                    starterPhrase = "It's been absolutely lovely chatting with you, but I've just spotted a colleague I need to catch up with before they head off.",
                    localTip = "Good excuses include: grabbing another drink, catching someone before they leave, or heading to the cloakroom."
                ),
                LondonScenario(
                    id = "soc_adv_5",
                    title = "De-escalating a minor social misunderstanding",
                    level = "Advanced",
                    situation = "You accidentally sat in someone's reserved theater seat, and they have approached you with their ticket.",
                    goal = "Apologize warmly, check your own ticket, realize the mistake, and resolve the situation with humor and politeness.",
                    starterPhrase = "Oh, I am so sorry! Let me check my ticket... Ah, I'm in row F, not E. My mistake, sorry to have taken your seat!",
                    localTip = "A warm, self-deprecating apology immediately defuses minor public friction in the UK."
                )
            ),
            usefulPhrases = listOf(
                UsefulPhrase("Fancy a cuppa?", "Would you like a cup of tea or coffee?", "Welcoming someone to your office or home."),
                UsefulPhrase("It's my round.", "It is my turn to pay for the drinks for the group.", "At a pub with friends or colleagues."),
                UsefulPhrase("Are you having a quiet one?", "Are you planning a relaxing weekend with few activities?", "Asking about weekend plans."),
                UsefulPhrase("Typical London weather!", "It is raining or changing rapidly, which is standard here.", "Standard casual icebreaker."),
                UsefulPhrase("Good to see you.", "Warm greeting used for friends or familiar colleagues.", "Meeting up for social events.")
            ),
            commonMistakes = listOf(
                CommonMistake("I want a tea.", "Would you mind if I grabbed a tea, please?", "Direct statements sound slightly demanding. Use soft phrasing like 'Could I possibly...' or 'Would it be alright if...'."),
                CommonMistake("What is your salary?", "What do you do for fun around London?", "Asking about salary, political views, or rent prices is considered intrusive in early UK social chat."),
                CommonMistake("I don't want to drink.", "I'm pacing myself tonight, thank you!", "You don't need to explain why you aren't drinking. A simple 'I'm pacing myself' or 'I'm on soft drinks' is perfectly respected."),
                CommonMistake("He was very nice and directly.", "He was very friendly and straightforward.", "Confusing 'directness' with friendliness. Londoners value indirect politeness, so someone being too direct might sound rude."),
                CommonMistake("The pub is too noisy.", "It's quite lively in here, isn't it?", "Complaining directly about noise sounds slightly grumpy. Use positive understatements like 'lively' or 'energetic' to describe busy venues.")
            ),
            localExpressions = listOf(
                LocalExpression("Fancy a cuppa?", "Friendly invitation to have a cup of tea.", "Fancy a cuppa before we start the meeting?"),
                LocalExpression("Having a quiet one", "Planning a calm, relaxing weekend.", "Are you going out tonight or just having a quiet one?"),
                LocalExpression("My round", "My turn to purchase drinks for everyone in our social group.", "Put your wallet away, it's my round!"),
                LocalExpression("Cheers, mate!", "Casual thank you or friendly goodbye.", "Cheers, mate! Appreciate you holding the door."),
                LocalExpression("Alright?", "Standard casual greeting meaning 'Hello, how are you?'.", "Alright? How was your weekend?")
            )
        ),

        // Category 8: Banking and bills
        LondonCategoryPack(
            categoryId = "banking_bills",
            categoryName = "Banking and bills",
            icon = "💳",
            beginnerScenarios = listOf(
                LondonScenario(
                    id = "bank_beg_1",
                    title = "Opening a basic bank account",
                    level = "Beginner",
                    situation = "You are at a high-street bank or contacting an online bank (like Monzo or Revolut) to open your first UK account.",
                    goal = "Ask the support agent what documents are accepted as proof of address for a new arrival.",
                    starterPhrase = "Hello, I've recently moved to the UK and would like to open a bank account. What documents do you accept as proof of address?",
                    localTip = "Online 'challenger' banks (like Monzo, Starling, or Revolut) have much simpler address verification requirements than traditional high street banks."
                ),
                LondonScenario(
                    id = "bank_beg_2",
                    title = "Setting up a Direct Debit",
                    level = "Beginner",
                    situation = "You want to set up an automatic monthly payment for your phone bill so you do not miss any deadlines.",
                    goal = "Ask the customer representative to help you set up a Direct Debit using your sort code and account number.",
                    starterPhrase = "Could you please help me set up a Direct Debit to pay my monthly mobile bill automatically?",
                    localTip = "Direct Debits are automated pulls managed by the billing company, whereas Standing Orders are push payments set up by you."
                ),
                LondonScenario(
                    id = "bank_beg_3",
                    title = "Reporting a lost debit card",
                    level = "Beginner",
                    situation = "You realized your debit card is missing, and you are concerned it might have been stolen.",
                    goal = "Call your bank's emergency line to report the card as lost and request a replacement.",
                    starterPhrase = "Hello, I've lost my debit card and need to freeze my account and order a replacement card, please.",
                    localTip = "Most UK banking apps allow you to instantly freeze and unfreeze your card with a single tap."
                ),
                LondonScenario(
                    id = "bank_beg_4",
                    title = "Asking about bank transfers",
                    level = "Beginner",
                    situation = "You need to transfer rent money to your landlord's account using Faster Payments.",
                    goal = "Ask the bank assistant how long a standard UK-to-UK bank transfer takes to arrive.",
                    starterPhrase = "If I make a bank transfer using Faster Payments, will the money arrive in the recipient's account immediately?",
                    localTip = "UK Faster Payments are typically instant, but can occasionally take up to two hours depending on security checks."
                ),
                LondonScenario(
                    id = "bank_beg_5",
                    title = "Understanding a utility bill",
                    level = "Beginner",
                    situation = "You have received your first water bill and are confused by the difference between metered and unmetered charges.",
                    goal = "Call the water company's customer service to ask them to explain the charges on your statement.",
                    starterPhrase = "Hi, I've just received my first water bill and was hoping someone could explain these charges to me.",
                    localTip = "Unmetered water bills charge a flat rate based on your property's historical size (rateable value), rather than your actual water use."
                )
            ),
            intermediateScenarios = listOf(
                LondonScenario(
                    id = "bank_int_1",
                    title = "Disputing an energy bill",
                    level = "Intermediate",
                    situation = "Your energy provider has sent you an estimated bill that is double your normal usage because they haven't updated your meter readings.",
                    goal = "Contact their billing team to submit your actual meter readings and request an updated statement.",
                    starterPhrase = "I am calling because my latest energy bill is based on an estimated reading that is far too high. I'd like to submit my actual meter readings, please.",
                    localTip = "Always submit regular meter readings to your energy supplier to prevent massive estimated billing corrections."
                ),
                LondonScenario(
                    id = "bank_int_2",
                    title = "Asking about overdraft fees",
                    level = "Intermediate",
                    situation = "You occasionally run low on funds before payday and want to understand the interest rates and fees for your bank's overdraft facility.",
                    goal = "Ask the bank advisor what the difference is between authorized and unauthorized overdraft limits.",
                    starterPhrase = "Could you please explain the interest rates and daily charges for using my authorized overdraft limit?",
                    localTip = "UK banks charge interest daily for arranged overdrafts, which can accumulate quickly if not managed carefully."
                ),
                LondonScenario(
                    id = "bank_int_3",
                    title = "Applying for a credit card",
                    level = "Intermediate",
                    situation = "You want to build your UK credit score by applying for a basic credit card and setting up a full-balance repayment schedule.",
                    goal = "Inquire with your bank about eligibility requirements and the APR (Annual Percentage Rate) for a rewards credit card.",
                    starterPhrase = "I'm interested in applying for a basic credit card to start building my UK credit history. What are the eligibility requirements?",
                    localTip = "Having no credit history in the UK can initially limit your options, but specialized 'credit builder' cards can help you establish a score."
                ),
                LondonScenario(
                    id = "bank_int_4",
                    title = "Canceling an active subscription",
                    level = "Intermediate",
                    situation = "You noticed an automated recurring card payment on your statement for a gym membership you canceled three months ago.",
                    goal = "Contact your bank to cancel the continuous payment authority and request a chargeback for the unauthorized charges.",
                    starterPhrase = "I have spotted a recurring payment on my statement for a gym subscription I cancelled months ago. Can we stop this continuous payment authority?",
                    localTip = "A Continuous Payment Authority (CPA) is different from a Direct Debit and must be cancelled directly with your bank if the merchant refuses."
                ),
                LondonScenario(
                    id = "bank_int_5",
                    title = "Querying international transfer costs",
                    level = "Intermediate",
                    situation = "You need to send £2,000 back to your home country bank account and want to compare high-street transfer fees with online specialist services.",
                    goal = "Ask your bank advisor about the transfer fees, exchange rates, and expected delivery times for an international wire.",
                    starterPhrase = "What are the transfer fees and exchange rates for sending money to an international account?",
                    localTip = "Online specialized transfer services (like Wise or OFX) are typically much cheaper and faster than traditional high-street banks."
                )
            ),
            advancedScenarios = listOf(
                LondonScenario(
                    id = "bank_adv_1",
                    title = "Reporting a credit card scam",
                    level = "Advanced",
                    situation = "You spotted three suspicious, high-value transactions on your credit card statement that you did not authorize.",
                    goal = "Contact your bank's fraud prevention team immediately to report the compromise, dispute the charges, and request a full fraud investigation.",
                    starterPhrase = "I need to report suspicious activity on my credit card. There are three transactions from yesterday that I definitely did not authorize.",
                    localTip = "UK banks have robust fraud protection policies under the Lending Standards Board guidelines, usually refunding unauthorized card charges immediately."
                ),
                LondonScenario(
                    id = "bank_adv_2",
                    title = "Resolving broadband billing contract dispute",
                    level = "Advanced",
                    situation = "Your broadband provider has increased your monthly contract price mid-term by 14% citing inflation, but your contract guaranteed a fixed rate.",
                    goal = "Contact their retention team to dispute the mid-term increase, cite your original contract terms, and demand either a price match or early cancellation without fee.",
                    starterPhrase = "I am disputing this mid-term price hike. My original agreement stated a fixed price, and I expect either that rate to be honored or an early contract exit without penalty.",
                    localTip = "UK telecom providers must allow you to leave your contract penalty-free if they increase prices mid-term above the rate stated in your terms."
                ),
                LondonScenario(
                    id = "bank_adv_3",
                    title = "Discussing mortgage pre-approval",
                    level = "Advanced",
                    situation = "You are preparing to buy your first home in London and want to obtain a mortgage 'Agreement in Principle' (AIP).",
                    goal = "Speak to a mortgage advisor to explain your income structure, deposit size, and request a formal affordability assessment.",
                    starterPhrase = "We are hoping to secure a mortgage Agreement in Principle. We have a twenty percent deposit saved and wanted to review our borrow capacity.",
                    localTip = "A mortgage Agreement in Principle (AIP) is vital when viewing London properties as it proves to sellers that you are a qualified buyer."
                ),
                LondonScenario(
                    id = "bank_adv_4",
                    title = "Negotiating payment holiday during emergency",
                    level = "Advanced",
                    situation = "Due to a sudden, unexpected redundancy, you are struggling to make your monthly personal loan repayments.",
                    goal = "Contact the bank's collections team proactively to explain your financial hardship and negotiate a temporary 3-month payment holiday.",
                    starterPhrase = "I have unfortunately been made redundant recently. I want to proactively discuss my options for a temporary payment holiday on my personal loan.",
                    localTip = "Always contact creditors proactively if you experience financial difficulty. UK lenders are legally required to treat hardship cases with empathy and forbearance."
                ),
                LondonScenario(
                    id = "bank_adv_5",
                    title = "Opening a joint bank account",
                    level = "Advanced",
                    situation = "You and your partner want to merge your utility payments and rent by opening a shared joint bank account.",
                    goal = "Consult a bank representative on the legal implications of joint accounts, credit scoring connections, and the closing procedure in case of separation.",
                    starterPhrase = "My partner and I would like to open a joint current account for our household expenses. Could you explain how this connects our credit files?",
                    localTip = "Opening a joint account creates a 'financial association' on your credit reports, meaning your partner's credit history can affect your score."
                )
            ),
            usefulPhrases = listOf(
                UsefulPhrase("I'd like to set up a Direct Debit.", "I want to authorize automatic monthly billing from my account.", "Managing recurring bill payments."),
                UsefulPhrase("Could you block this card, please?", "I need to freeze my debit card immediately because it is missing.", "Emergency fraud prevention."),
                UsefulPhrase("What are the sort code and account number?", "What are the unique numeric identifiers for my UK bank account?", "Setting up local bank transfers."),
                UsefulPhrase("My billing statement is estimated.", "The energy company calculated my bill using predictions rather than actual meter readings.", "Disputing utility bills."),
                UsefulPhrase("Is there an overdraft fee?", "What are the interest rates and charges if my balance drops below zero?", "Reviewing bank account terms.")
            ),
            commonMistakes = listOf(
                CommonMistake("Send me the money using my routing number.", "Could I get your sort code and account number, please?", "The UK banking system does not use 'routing numbers'. Instead, they use a 6-digit 'sort code' and an 8-digit 'account number'."),
                CommonMistake("I want to set up an automatic pay.", "I'd like to set up a Direct Debit.", "Automated recurring bill payments are formally called 'Direct Debits' or 'standing orders' in the UK."),
                CommonMistake("The bank made me a fraud.", "I've been a victim of fraud on my card.", "Saying 'the bank made me a fraud' implies the bank is doing something illegal. Use 'unauthorized transaction' or 'fraudulent activity on my card'."),
                CommonMistake("I have a check.", "I have a cheque to pay in.", "In the UK, the paper payment document is spelled 'cheque', rather than the American spelling 'check'."),
                CommonMistake("The electricity company billed me too much.", "My latest electricity statement is based on an estimated reading.", "Rather than complaining aggressively about a billing mistake, frame it politely as 'an estimated statement that requires correction with meter readings'.")
            ),
            localExpressions = listOf(
                LocalExpression("Sort code", "The 6-digit code identifying your bank branch.", "You'll need my sort code and account number to transfer the funds."),
                LocalExpression("Direct Debit", "An automatic monthly utility payment pulled by the merchant.", "My broadband bill is paid automatically via Direct Debit."),
                LocalExpression("Faster Payments", "The instant electronic UK-to-UK bank transfer system.", "I transferred the rent money, it should arrive instantly via Faster Payments."),
                LocalExpression("Meter reading", "Actual number units shown on your physical electricity or water meter.", "I need to submit my monthly gas meter reading to get an accurate bill."),
                LocalExpression("Payment holiday", "A temporary authorized pause on credit or loan repayments.", "My bank granted me a three-month payment holiday after my redundancy.")
            )
        ),

        // Category 9: Council and local services
        LondonCategoryPack(
            categoryId = "council_services",
            categoryName = "Council and local services",
            icon = "🏛️",
            beginnerScenarios = listOf(
                LondonScenario(
                    id = "coun_beg_1",
                    title = "Inquiring about bin collection days",
                    level = "Beginner",
                    situation = "You have recently moved to a new house and do not know which days the rubbish and recycling bins are collected.",
                    goal = "Contact your local borough council's waste helpline or check online to ask for the weekly collection schedule.",
                    starterPhrase = "Hello, I've just moved to this address. Could you please tell me which days our general waste and recycling bins are collected?",
                    localTip = "In London, waste collection schedules and recycling rules are determined entirely by your individual local borough council."
                ),
                LondonScenario(
                    id = "coun_beg_2",
                    title = "Applying for a library card",
                    level = "Beginner",
                    situation = "You want to join your local borough library to borrow books and access free digital study resources.",
                    goal = "Approach the library desk, show your ID and proof of address, and ask to register for a library card.",
                    starterPhrase = "Hi, I'd like to sign up for a library card. I have my passport and a utility bill here as proof of address.",
                    localTip = "Your local library card often gives you free online access to premium newspapers, academic journals, and ebooks."
                ),
                LondonScenario(
                    id = "coun_beg_3",
                    title = "Reporting a street issue",
                    level = "Beginner",
                    situation = "There is a broken street lamp outside your house that has been flickering and dark for a week.",
                    goal = "Call or message the council's street maintenance team to report the broken lamp post.",
                    starterPhrase = "Hello, I'd like to report a broken street lamp outside number forty-five on High Street. It's been completely dark for a week.",
                    localTip = "Many London councils use the website or app 'FixMyStreet' to let residents easily report potholes, fly-tipping, and broken lights."
                ),
                LondonScenario(
                    id = "coun_beg_4",
                    title = "Asking about local parks",
                    level = "Beginner",
                    situation = "You want to know if the nearby council park has free tennis courts or public barbecue facilities.",
                    goal = "Ask a council park assistant or check with the local services desk about park rules and sports bookings.",
                    starterPhrase = "Hi, are the tennis courts in the local park free to use, or do I need to book them online?",
                    localTip = "Most council tennis courts require booking online, and barbecues are strictly banned in almost all London parks to prevent fires."
                ),
                LondonScenario(
                    id = "coun_beg_5",
                    title = "Confirming your voter registration",
                    level = "Beginner",
                    situation = "You want to make sure you are registered to vote on the electoral roll at your new address.",
                    goal = "Ask the council's electoral registration team to check if your details have been updated successfully.",
                    starterPhrase = "Hello, I recently registered to vote online and wanted to double-check if my name is on the electoral register for my new address.",
                    localTip = "Being on the electoral roll is highly beneficial as it significantly improves your UK credit rating score."
                )
            ),
            intermediateScenarios = listOf(
                LondonScenario(
                    id = "coun_int_1",
                    title = "Applying for a resident parking permit",
                    level = "Intermediate",
                    situation = "You have bought a car and need to apply for a resident parking permit to park in the restricted zone outside your flat.",
                    goal = "Contact the council's parking department to ask about permit costs, required documents, and processing times.",
                    starterPhrase = "I need to apply for a resident parking permit for my vehicle. What documents do I need to submit to prove my residency?",
                    localTip = "Resident parking fees in London are heavily scaled based on your car's carbon dioxide emissions."
                ),
                LondonScenario(
                    id = "coun_int_2",
                    title = "Reporting fly-tipping",
                    level = "Intermediate",
                    situation = "Someone has illegally dumped a large, broken mattress and several bags of construction waste on the pavement near your house.",
                    goal = "Contact the council's environmental team to report the fly-tipping and request immediate clearance.",
                    starterPhrase = "I'd like to report a case of fly-tipping. Someone has dumped a large double mattress and construction waste on the corner of our street.",
                    localTip = "Fly-tipping is a serious criminal offense in the UK, carrying unlimited fines for offenders caught dumping waste illegally."
                ),
                LondonScenario(
                    id = "coun_int_3",
                    title = "Applying for Council Tax discount",
                    level = "Intermediate",
                    situation = "You live alone in your flat and are eligible for the 25% single person discount on your annual Council Tax bill.",
                    goal = "Ask the council's finance officer how to apply for the single-occupancy discount on their online portal.",
                    starterPhrase = "I am currently living alone in my flat and would like to apply for the twenty-five percent single person discount on my Council Tax.",
                    localTip = "Full-time students are entirely exempt from paying Council Tax, but you must submit an official exemption letter from your university."
                ),
                LondonScenario(
                    id = "coun_int_4",
                    title = "Booking a bulky waste collection",
                    level = "Intermediate",
                    situation = "You are replacing your old sofa and need the council to come and collect the bulky item for disposal.",
                    goal = "Inquire about the booking procedure, fees, and collection guidelines for large household waste items.",
                    starterPhrase = "I need to book a bulky waste collection for an old sofa. Could you tell me how much the service costs and where to leave the item?",
                    localTip = "Leaving bulky waste on the pavement without booking a collection is treated as illegal fly-tipping."
                ),
                LondonScenario(
                    id = "coun_int_5",
                    title = "Inquiring about local allotments",
                    level = "Intermediate",
                    situation = "You want to rent a small plot of land (an allotment) in your local area to grow your own vegetables.",
                    goal = "Ask the council's leisure or green spaces team about allotment availability, waiting list lengths, and fees.",
                    starterPhrase = "I'm interested in renting a local council allotment. Is there currently a waiting list, and how do I apply?",
                    localTip = "Allotment plots in London are highly sought after, with waiting lists in some popular boroughs extending for several years."
                )
            ),
            advancedScenarios = listOf(
                LondonScenario(
                    id = "coun_adv_1",
                    title = "Challenging a Penalty Charge Notice (PCN)",
                    level = "Advanced",
                    situation = "You received a parking fine (Penalty Charge Notice) from the council, but the warning signs were entirely blocked by an overgrown tree.",
                    goal = "Speak to or write to the parking appeals officer to argue against the PCN, presenting evidence of the obscured signage.",
                    starterPhrase = "I wish to challenge this Penalty Charge Notice. The restricted parking signs were completely obscured by an overgrown tree, as shown in my photos.",
                    localTip = "If you pay a PCN within 14 days, the council typically reduces the fine amount by fifty percent."
                ),
                LondonScenario(
                    id = "coun_adv_2",
                    title = "Objecting to local planning permission",
                    level = "Advanced",
                    situation = "A local commercial developer has applied to build a 24-hour convenience store directly next to your residential building.",
                    goal = "Submit a formal objection to the council's planning committee citing concerns about noise pollution, waste management, and traffic safety.",
                    starterPhrase = "I am writing to register a formal objection to planning application 3920. The proposal for a twenty-four hour store will cause significant noise pollution.",
                    localTip = "Planning objections must be based on valid structural concerns (like noise, light, or traffic), rather than personal disagreements or property value."
                ),
                LondonScenario(
                    id = "coun_adv_3",
                    title = "Applying for a street party license",
                    level = "Advanced",
                    situation = "You and your neighbors want to organize a local street party for a summer festival, which requires closing the road for a day.",
                    goal = "Inquire with the council's events team about road closure permits, liability insurance, and application deadlines.",
                    starterPhrase = "We are hoping to organize a neighborhood street party and would like to apply for a temporary road closure permit for our street.",
                    localTip = "Councils usually waive road closure fees for non-commercial community street parties, but require several weeks' notice."
                ),
                LondonScenario(
                    id = "coun_adv_4",
                    title = "Navigating school place admissions",
                    level = "Advanced",
                    situation = "You are applying for a primary school place for your child but were assigned a school outside your local catchment area.",
                    goal = "Contact the council's school admissions team to appeal the decision, citing proximity and specific educational needs.",
                    starterPhrase = "We wish to appeal our child's school allocation. The assigned school is over three miles away, whereas our local catchment school has vacancies.",
                    localTip = "UK school admissions are strictly managed based on catchment zones (proximity to the school) and sibling rules."
                ),
                LondonScenario(
                    id = "coun_adv_5",
                    title = "Reporting local council neglect",
                    level = "Advanced",
                    situation = "The local council playground has broken swings and shattered glass, presenting an immediate hazard to children.",
                    goal = "Speak to the environmental health manager to report the danger, emphasizing the council's potential liability in case of accidents.",
                    starterPhrase = "I need to report an urgent safety hazard at the local playground. There are broken swings and shattered glass, which presents an immediate danger to children.",
                    localTip = "Local councils have a statutory duty of care to maintain public facilities and can be held liable for injuries caused by negligence."
                )
            ),
            usefulPhrases = listOf(
                UsefulPhrase("Which borough council is this?", "What is the name of the municipal local authority for this address?", "Identifying your local council."),
                UsefulPhrase("I need to submit my Council Tax forms.", "I want to file my local tax details with the council office.", "Registering for municipal tax."),
                UsefulPhrase("Is there a bulky waste collection?", "Does the council offer a service to pick up large household items?", "Managing furniture disposal."),
                UsefulPhrase("Could I appeal this parking fine?", "Is it possible to formally dispute this Penalty Charge Notice?", "Handling local driving fines."),
                UsefulPhrase("I'd like to join the library.", "I want to register as a member of the local public library.", "Visiting a community center.")
            ),
            commonMistakes = listOf(
                CommonMistake("I want to pay my city tax.", "I need to register for Council Tax, please.", "In the UK, local municipal tax is strictly called 'Council Tax', never 'city tax' or 'town tax'."),
                CommonMistake("The garbage truck didn't come.", "Our rubbish and recycling bins were missed today.", "UK residents refer to household waste collection as 'bin collection' or 'rubbish collection' rather than 'garbage trucks'."),
                CommonMistake("I have a ticket for my car.", "I received a Penalty Charge Notice for parking.", "Parking tickets issued by councils are formally called 'Penalty Charge Notices' (PCNs)."),
                CommonMistake("Where is the trash dump?", "Where is the local recycling and reuse center?", "Avoid calling waste facilities 'trash dumps'. Use the polite UK term 'recycling and reuse center' or 'local tip'."),
                CommonMistake("I want to complain about my neighbors' construction.", "I'd like to check the local planning application registry.", "Rather than complaining directly, enquire professionally about 'planning applications' or 'reporting a noise nuisance' to environmental health.")
            ),
            localExpressions = listOf(
                LocalExpression("Council Tax", "Local tax paid to the municipal borough.", "How much is the Council Tax band for this property?"),
                LocalExpression("Borough", "A division of London with its own local council.", "I live in the borough of Islington, which has excellent recycling facilities."),
                LocalExpression("Penalty Charge Notice", "The official term for a municipal parking or traffic fine.", "I got a Penalty Charge Notice for parking in a resident bay."),
                LocalExpression("Fly-tipping", "The illegal dumping of waste in public spaces.", "The council has put up cameras to prevent fly-tipping in the alleyway."),
                LocalExpression("FixMyStreet", "Popular UK app used to report potholes and broken streetlights.", "I reported the broken pavement outside our flat using the FixMyStreet app.")
            )
        ),

        // Category 10: Complaints and refunds
        LondonCategoryPack(
            categoryId = "complaints_refunds",
            categoryName = "Complaints and refunds",
            icon = "💔",
            beginnerScenarios = listOf(
                LondonScenario(
                    id = "comp_beg_1",
                    title = "Requesting a restaurant refund",
                    level = "Beginner",
                    situation = "You ordered a vegetarian meal, but the waiter brought a plate containing chicken.",
                    goal = "Politely point out the mistake and ask for a fresh meal or a refund.",
                    starterPhrase = "Excuse me, I ordered the vegetarian option, but this plate seems to have chicken in it.",
                    localTip = "Polite but clear notification of dietary requirements is highly respected in UK hospitality."
                ),
                LondonScenario(
                    id = "comp_beg_2",
                    title = "Returning clothes with receipt",
                    level = "Beginner",
                    situation = "You bought a shirt that is too small, and you are returning it within the 14-day return window.",
                    goal = "Present the receipt and ask the cashier for a full refund to your original payment card.",
                    starterPhrase = "Hi, I'd like to return this shirt for a refund. I have the receipt and it's within fourteen days.",
                    localTip = "Refunds are almost always returned to the original payment card to comply with anti-money laundering laws."
                ),
                LondonScenario(
                    id = "comp_beg_3",
                    title = "Complaining about cold food",
                    level = "Beginner",
                    situation = "Your pub lunch has arrived, but the chips are completely cold and soggy.",
                    goal = "Politely tell the server that your chips are cold and ask for a hot replacement batch.",
                    starterPhrase = "Excuse me, sorry to bother you, but our chips have arrived quite cold. Could we get a fresh batch, please?",
                    localTip = "Starting complaints with 'Excuse me, sorry to bother you...' is a very British way to keep the interaction polite."
                ),
                LondonScenario(
                    id = "comp_beg_4",
                    title = "Querying a wrong shelf price",
                    level = "Beginner",
                    situation = "A supermarket item was marked as £2 on the shelf but scanned as £3.50 at the self-checkout.",
                    goal = "Call the checkout assistant over to point out the price difference and request a correction.",
                    starterPhrase = "Hi, this item scanned at three pounds fifty, but the shelf label said it was only two pounds.",
                    localTip = "Self-checkout areas always have assistants on duty to resolve pricing discrepancies quickly."
                ),
                LondonScenario(
                    id = "comp_beg_5",
                    title = "Asking about a missing parcel",
                    level = "Beginner",
                    situation = "Your online delivery has not arrived within the promised 3-day window.",
                    goal = "Message the seller's helpline to check the delivery status and request an update.",
                    starterPhrase = "Hello, my order hasn't arrived within the expected three days. Could you please check its delivery status?",
                    localTip = "Online retailers are legally responsible for goods until they are delivered to your safe possession."
                )
            ),
            intermediateScenarios = listOf(
                LondonScenario(
                    id = "comp_int_1",
                    title = "Hotel room heating failure",
                    level = "Intermediate",
                    situation = "The radiator in your hotel room is broken, making the room uncomfortably cold at night.",
                    goal = "Call the front desk to explain the issue, ask for a portable heater, or request a room change.",
                    starterPhrase = "The heating in our room doesn't seem to be working, and it's getting quite cold. Could we get a portable heater or swap rooms?",
                    localTip = "Hotels are expected to provide reasonable comfort. Mentioning discomfort politely usually secures a swift room upgrade."
                ),
                LondonScenario(
                    id = "comp_int_2",
                    title = "Gym membership contract dispute",
                    level = "Intermediate",
                    situation = "You signed up for a gym membership under a promotion promising free cancelation, but the gym is now claiming you must pay a £100 exit fee.",
                    goal = "Contact their finance team, cite the original promotional terms, and request that the exit fee be waived.",
                    starterPhrase = "I signed up under a promotion that guaranteed penalty-free cancellation. I'd like this hundred-pound exit fee waived as per those terms.",
                    localTip = "Always keep screenshots of promotional offers as gyms are notorious for enforcing obscure contract clauses."
                ),
                LondonScenario(
                    id = "comp_int_3",
                    title = "Late flight compensation",
                    level = "Intermediate",
                    situation = "Your short-haul flight from London to Paris was delayed by over three hours due to airline boarding issues.",
                    goal = "Contact the airline's customer service to claim statutory compensation under UK261 regulations.",
                    starterPhrase = "I am writing to claim compensation under UK261 for my flight which was delayed by over three hours due to boarding delays.",
                    localTip = "Under UK261 rules, you are entitled to flat-rate compensation for flight delays over 3 hours, unless caused by extraordinary circumstances."
                ),
                LondonScenario(
                    id = "comp_int_4",
                    title = "Incomplete service complaint",
                    level = "Intermediate",
                    situation = "You paid a professional cleaning company £150 for a deep clean, but they completely skipped cleaning the kitchen cabinets.",
                    goal = "Call the agency manager to complain about the missed kitchen work and request a partial refund or a re-cleaning visit.",
                    starterPhrase = "The cleaners did a good job on the carpets, but they completely skipped the kitchen cabinets despite our deep-clean agreement.",
                    localTip = "Cleaning companies usually prefer sending a cleaner back to resolve missed areas rather than issuing direct cash refunds."
                ),
                LondonScenario(
                    id = "comp_int_5",
                    title = "Broadband speed drop complaint",
                    level = "Intermediate",
                    situation = "Your broadband speed is averaging only 5 Mbps, despite your contract promising a minimum of 50 Mbps.",
                    goal = "Contact technical support to report the persistent speed drop and ask them to verify the line connection.",
                    starterPhrase = "My broadband speeds have dropped consistently below the minimum guaranteed speed of fifty megabits. Could you run a diagnostic?",
                    localTip = "The UK regulator Ofcom enforces a code of practice requiring providers to let you leave penalty-free if speeds remain slow."
                )
            ),
            advancedScenarios = listOf(
                LondonScenario(
                    id = "comp_adv_1",
                    title = "Escalating a complaint to the Ombudsman",
                    level = "Advanced",
                    situation = "Your energy company has ignored your billing dispute for eight weeks, leaving you with an incorrect debt threat.",
                    goal = "Explain to the customer relations director that you will escalate the matter to the official Energy Ombudsman for an independent audit.",
                    starterPhrase = "Since this dispute has remained unresolved for eight weeks, I will now be escalating this matter to the Energy Ombudsman for a formal review.",
                    localTip = "In the UK, if a utility, financial, or telecom company fails to resolve a complaint within 8 weeks, you have the right to take it to the Ombudsman for free."
                ),
                LondonScenario(
                    id = "comp_adv_2",
                    title = "Demanding refund for defective high-value goods",
                    level = "Advanced",
                    situation = "A high-end smartphone you purchased for £900 has developed a severe motherboard crash within 30 days of purchase.",
                    goal = "Visit the retail store manager, assert your 'short-term right to reject' under the Consumer Rights Act 2015, and refuse their offer to repair it, demanding a full refund.",
                    starterPhrase = "Under the Consumer Rights Act, as this fault occurred within thirty days, I am exercising my short-term right to reject and requesting a full refund.",
                    localTip = "The Consumer Rights Act 2015 gives you an absolute right to a full refund for defective goods within the first 30 days of ownership."
                ),
                LondonScenario(
                    id = "comp_adv_3",
                    title = "Addressing holiday package cancellation breach",
                    level = "Advanced",
                    situation = "A travel agency canceled your holiday package to Italy due to staff shortages, and is offering vouchers instead of a cash refund.",
                    goal = "Contact the agency director to state that under Package Travel Regulations, you are entitled to a full cash refund within 14 days, and refuse the vouchers.",
                    starterPhrase = "Under the Package Travel Regulations, I am entitled to a full cash refund within fourteen days for this cancellation, so I cannot accept vouchers.",
                    localTip = "Package holiday providers are legally required to offer cash refunds for cancellations; vouchers are entirely optional for you to accept."
                ),
                LondonScenario(
                    id = "comp_adv_4",
                    title = "Handling poor vehicle repair disputes",
                    level = "Advanced",
                    situation = "A local garage charged you £500 to fix a cooling leak in your car, but the car overheated and broke down just twenty miles later with the same leak.",
                    goal = "Call the garage owner to argue that their service was not carried out with reasonable care and skill under the Consumer Rights Act, and demand they tow and repair the vehicle for free.",
                    starterPhrase = "The coolant leak persist despite your repair yesterday. Under the Consumer Rights Act, I expect you to tow and resolve this at no extra cost.",
                    localTip = "Service providers in the UK must perform work with 'reasonable care and skill'. If they fail, they must remedy it at their own expense."
                ),
                LondonScenario(
                    id = "comp_adv_5",
                    title = "Challenging an unfair dry-cleaning damage waiver",
                    level = "Advanced",
                    situation = "A dry cleaner damaged a high-value silk dress and is refusing compensation, pointing to an 'owners risk' clause printed on the back of your receipt.",
                    goal = "Explain to the manager that unfair exclusion clauses are legally void under the Consumer Rights Act, and threaten to escalate to small claims court.",
                    starterPhrase = "An 'owners risk' clause cannot exclude liability for dry-cleaning negligence under the Consumer Rights Act. I expect full compensation for this damaged silk dress.",
                    localTip = "Businesses cannot use 'fine print waivers' to escape liability for negligent damage to your personal property."
                )
            ),
            usefulPhrases = listOf(
                UsefulPhrase("Under the Consumer Rights Act...", "Citing the statutory legislation protecting UK buyers.", "Asserting legal consumer rights."),
                UsefulPhrase("I'd like to escalate this complaint.", "I want to speak with a more senior manager regarding this issue.", "Demanding escalation."),
                UsefulPhrase("I will contact the Ombudsman.", "Threatening to escalate the dispute to the official government independent regulator.", "Handling unresolved company disputes."),
                UsefulPhrase("I am exercising my right to reject.", "Asserting your legal right to return a defective item within 30 days for a full refund.", "Returning a faulty product."),
                UsefulPhrase("Excuse me, this isn't what I ordered.", "Politely informing staff that there is an error in your meal or item.", "Correcting a service mistake.")
            ),
            commonMistakes = listOf(
                CommonMistake("I will sue you in court.", "I will have to escalate this to the small claims court / Ombudsman.", "Direct threats of 'suing' sound overly dramatic and American. Refer instead to 'the Ombudsman' or 'the small claims court'."),
                CommonMistake("Give me my money now.", "I'd like to request a full refund under my statutory rights.", "Aggressive demands usually lead to defensive responses. Cite your 'statutory rights' and remain calm but firm."),
                CommonMistake("This food is garbage.", "Excuse me, our food has arrived quite cold. Could we swap this, please?", "Insulting staff or products directly reduces your chances of sympathetic service. Use polite British understatement."),
                CommonMistake("Your fine print says you are not responsible.", "Exclusion clauses for negligence are void under the Consumer Rights Act.", "Do not accept unfair waivers blindly. UK law protects consumers against unfair contract terms regardless of fine print."),
                CommonMistake("I have to make a big dispute.", "I'd like to raise a formal complaint, please.", "Instead of saying 'make a big dispute', use the standard UK professional phrase 'raise a formal complaint'.")
            ),
            localExpressions = listOf(
                LocalExpression("Consumer Rights Act", "The 2015 UK legislation protecting consumer purchases of goods and services.", "The Consumer Rights Act protects me if this toaster breaks down within six months."),
                LocalExpression("Ombudsman", "An independent official appointed to investigate public complaints against companies.", "If the energy company doesn't resolve my bill, I'll take it to the Ombudsman."),
                LocalExpression("Small claims court", "Simple court track for resolving minor financial disputes up to £10,000.", "I will take the dry cleaners to small claims court if they refuse to pay for my dress."),
                LocalExpression("Right to reject", "Statutory 30-day window to return faulty goods for a full refund.", "I am exercising my right to reject this faulty laptop within thirty days."),
                LocalExpression("Service charge removal", "Polite request to remove optional tip from restaurant bills due to poor service.", "We asked for the service charge removal because our waiter was extremely dismissive.")
            )
        )
    )
}
