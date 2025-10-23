package site.remlit.blueb.asterTestPlugin

import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import org.jetbrains.exposed.v1.core.neq
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import site.remlit.blueb.aster.db.table.UserTable
import site.remlit.blueb.aster.event.EventRegistry
import site.remlit.blueb.aster.event.note.NoteCreateEvent
import site.remlit.blueb.aster.plugin.AsterPlugin
import site.remlit.blueb.aster.route.RouteRegistry
import site.remlit.blueb.aster.service.UserService

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
			val count = UserService.count(UserTable.host neq null)

			get("/test-plugin-route") {
				call.respondText {
					"TestPlugin route works! $count remote users known of."
				}
			}
		}
	}

	override fun disable() { }
}