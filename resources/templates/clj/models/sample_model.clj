(ns app.models.{{name}}
    (:use [korma.core]))

(defentity users
  ;; Basic configuration

  ;; Table, by default the name of the entity
  {% if table %}
  (table :{{table}})
  {% else %}
  (table :{{name}})
  {% endif %}

  ;; by default "id". This line is unnecessary.
  ;; it's used for relationships joins.
  (pk :id)
  (database db) ;; if none is specified the last defdb
  ;; will be used. Also unnecessary.
  (entity-fields :first :last) ;; default fields for selects

  ;; Mutations
  (prepare (fn [{last :last :as v}]
             (if last
               (assoc v :last (str/upper-case last)) v)))
  ;; apply a function before storing in the db
  ;; in this case the function changes the "last" field
  ;; to upper case.
  (transform (fn [{first :first :as v}]
               (if first
                 (assoc v :first (str/capitalize first)) v)))
  ;; apply a function to all select results
  ;; in this case the function changes the "first" field
  ;; to capitalized.

  ;; Relationships
  (has-one address)
  ;; assumes users.id = address.users_id
  (has-many email)
  ;; assumes users.id = email.users_id
  ;; but gets the results in a second query
  ;; for each element
  (belongs-to account)
  ;; assumes users.account_id = account.id
  (many-to-many posts :users_posts))
;; assumes a table users_posts with columns users_id
;; and posts_id
;; like has-many, also gets the results in a second
;; query for each element
