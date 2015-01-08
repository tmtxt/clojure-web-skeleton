(ns app.views.layout
  (:require [selmer.parser :as parser]
            [ring.util.response :refer [content-type response]]
            [compojure.response :refer [Renderable]]))

;; (def template-folder "templates/")
(parser/set-resource-path! (clojure.java.io/resource "templates"))

(defn utf-8-response [html]
  (content-type (response html) "text/html; charset=utf-8"))

(deftype RenderablePage [template params]
  Renderable
  (render [this request]
    (->> (parser/render-file (str template) params)
         utf-8-response)))

(defn render [template & [params]]
  (RenderablePage. template params))
