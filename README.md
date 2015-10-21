# es-setup

A simple [Joplin](https://github.com/juxt/joplin) setup to migrate a local Elasticsearch node (:9200) to add a location index. It will seed the node with the country data in resources/country

## Usage

Checkout, then, `git submodule update`, `lein migrate dev es` to migrate the ES node (see `resources/joplin.edn` to change locations) & `lein seed dev es` to upload the data.

## License

Copyright © 2015 David Humphreys

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
