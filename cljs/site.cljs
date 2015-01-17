(ns site
  (:require [clojure.browser.repl :as repl]))

(defn ^:export init []
  (.log js/console "hello world")
  (repl/connect "http://localhost:9253/repl"))
