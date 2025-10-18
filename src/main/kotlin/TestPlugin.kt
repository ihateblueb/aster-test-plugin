package site.remlit.blueb.asterTestPlugin

import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import site.remlit.blueb.aster.event.EventRegistry
import site.remlit.blueb.aster.event.note.NoteCreateEvent
import site.remlit.blueb.aster.plugin.AsterPlugin
import site.remlit.blueb.aster.route.RouteRegistry

@Suppress("Unused")
class TestPlugin : AsterPlugin {
	override val logger: Logger =
		LoggerFactory.getLogger(this::class.java)

	override fun enable() {
		EventRegistry.addListener(NoteCreateEvent::class) {
			it as NoteCreateEvent
			logger.info("Received note create event: ${it.note}")
		}

		RouteRegistry.registerRoute {
			get("/test-plugin-route") {
				call.respondText {
					"TestPlugin route works!"
				}
			}
		}
	}

	override fun disable() { }
}