(ns re-simple-term.config)

(def debug?
  ^boolean js/goog.DEBUG)

(when debug?
  (enable-console-print!))
