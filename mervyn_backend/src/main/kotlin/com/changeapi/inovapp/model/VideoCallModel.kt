package com.changeapi.inovapp.model

data class VideoCallModel (
    val startDateTime: String,
    val endDateTime: String,
    val subject: String
)

data class VideoCallRequest (
    val startDateTime: String,
    val endDateTime: String,
    val subject: String,
    val requestorName: String,
    val requestorCir: String,
    val requestorPhoneNum: String,
    val reason: String
)

data class OnlineMeeting(
    val odataContext: String,
    val id: String,
    val creationDateTime: String,
    val startDateTime: String,
    val endDateTime: String,
    val joinUrl: String,
    val joinWebUrl: String,
    val meetingCode: String,
    val subject: String,
    val isBroadcast: Boolean,
    val autoAdmittedUsers: String,
    val outerMeetingAutoAdmittedUsers: Any?,
    val isEntryExitAnnounced: Boolean,
    val allowedPresenters: String,
    val allowMeetingChat: String,
    val shareMeetingChatHistoryDefault: String,
    val allowTeamworkReactions: Boolean,
    val allowAttendeeToEnableMic: Boolean,
    val allowAttendeeToEnableCamera: Boolean,
    val recordAutomatically: Boolean,
    val anonymizeIdentityForRoles: List<Any>,
    val capabilities: List<Any>,
    val videoTeleconferenceId: String,
    val externalId: Any?,
    val iCalUid: Any?,
    val meetingType: Any?,
    val allowParticipantsToChangeName: Boolean,
    val allowRecording: Boolean,
    val allowTranscription: Boolean,
    val meetingMigrationMode: Any?,
    val broadcastSettings: Any?,
    val audioConferencing: Any?,
    val meetingInfo: Any?,
    val watermarkProtection: Any?,
    val participants: Participants,
    val lobbyBypassSettings: LobbyBypassSettings,
    val joinMeetingIdSettings: JoinMeetingIdSettings,
    val chatInfo: ChatInfo,
    val joinInformation: JoinInformation
)

data class Participants(
    val organizer: Organizer,
    val attendees: List<Any>
)

data class Organizer(
    val upn: String,
    val role: String,
    val identity: Identity
)

data class Identity(
    val application: Any?,
    val device: Any?,
    val user: User
)

data class User(
    val id: String,
    val displayName: Any?,
    val tenantId: String,
    val identityProvider: String
)

data class LobbyBypassSettings(
    val scope: String,
    val isDialInBypassEnabled: Boolean
)

data class JoinMeetingIdSettings(
    val isPasscodeRequired: Boolean,
    val joinMeetingId: String,
    val passcode: Any?
)

data class ChatInfo(
    val threadId: String,
    val messageId: String,
    val replyChainMessageId: Any?
)

data class JoinInformation(
    val content: String
)
