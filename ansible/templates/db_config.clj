;;; GENERATED BY ANSIBLE. DO NO EDIT
(ns app.db.config
  (:use [korma.db]))

(def db (postgres {:db "{{db_name}}"
                   :user "{{db_user}}"
                   :password "{{db_password}}"
                   :host "{{db_host}}"
                   :port "5432"
                   :delimiters ""}))