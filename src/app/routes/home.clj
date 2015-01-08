(ns app.routes.home
  (:require [compojure.core :refer :all]
            [app.views.layout :as layout]
            [selmer.parser :refer [render-file render]]))

(defn home []
  (layout/render "home/index.html" {:name "Truong"}))

(defroutes home-routes
  (GET "/" [] (home)))
