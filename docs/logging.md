The skeleton uses [Clojure Logging](https://github.com/clojure/tools.logging)
with **Log4j** behind it by default.

```
(ns example.app
  (:require [clojure.tools.logging :as log]))

;; increasing level of severe
(log/trace "some string")
(log/debug "some string")
(log/info "some string")
(log/warn "some string")
(log/error "some string")
(log/fatal "some string")
```

By default, all the output sent to stdout will be redirected to
`logs/ring-server.log` and the log you call with **Clojure Logging** (with log4j
by default) will be appended to `logs/log4j.log`. You can config log4j for
specific namespace in `src/log4j.xml`. See more about the log4j XML structure
here
[http://wiki.apache.org/logging-log4j/Log4jXmlFormat](http://wiki.apache.org/logging-log4j/Log4jXmlFormat).
