package site.remlit.blueb.asterTestPlugin

import site.remlit.blueb.aster.event.EventRegistry
import site.remlit.blueb.aster.event.note.NoteCreateEvent
import site.remlit.blueb.aster.plugin.AsterPlugin

@Suppress("Unused")
class TestPlugin : AsterPlugin {
	override fun enable() {
		println("tp: Plugin enabled!")

		EventRegistry.addListener(NoteCreateEvent::class) {
			it as NoteCreateEvent
			println("tp: Received note create event: ${it.note}")
		}
	}

	override fun disable() {
		println("tp: Plugin disabled!")
	}
}