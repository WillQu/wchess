package bootstrap.liftweb

import net.liftweb.http.{
  Html5Properties,
  LiftRules,
  SecurityRules,
  ContentSecurityPolicy,
  ContentSourceRestriction,
  Req
}
import net.liftweb.sitemap.{Menu, SiteMap}

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot: Unit = {
    // where to search snippet
    LiftRules.addToPackages("chess")

    // Build SiteMap
    def sitemap(): SiteMap = SiteMap(
      Menu.i("Home") / "index",
      Menu.i("Chessboard") / "chessboard"
    )

    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) =>
      new Html5Properties(r.userAgent))

    // Content Security Policy
    LiftRules.securityRules = () => new SecurityRules(
      content = Some(new ContentSecurityPolicy(defaultSources =
        List(ContentSourceRestriction.Self, ContentSourceRestriction.UnsafeInline))))
  }
}
