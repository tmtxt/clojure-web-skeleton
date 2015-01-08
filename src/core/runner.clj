(ns core.runner
  (:require [app.repl :as web-server]
            [clojure.tools.nrepl.server :as repl-server]))

(defn -main
  [& args]
  (web-server/start-server "3000")
  (repl-server/start-server :port 7888))
