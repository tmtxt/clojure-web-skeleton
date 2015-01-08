(ns app.handler
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [ring.middleware.session.memory :refer [memory-store]]
            [hiccup.middleware :refer [wrap-base-url]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [app.routes.home :refer [home-routes]]
            [noir.session :as session]
            [noir.validation :as validation]))

(defn init []
  (println "app is starting"))

(defn destroy []
  (println "app is shutting down"))

(defroutes app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (routes home-routes
              app-routes)
      (handler/site)
      (wrap-base-url)
      (session/wrap-noir-session {:store (memory-store)})
      (validation/wrap-noir-validation)))
