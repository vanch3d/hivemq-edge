import 'cypress-axe'
import 'cypress-each'
import '@percy/cypress'
import 'cypress-real-events'
import '@cypress/code-coverage/support'

import './commands'

import installLogsCollector from 'cypress-terminal-report/src/installLogsCollector'

installLogsCollector()

// Alternatively you can use CommonJS syntax:
// require('./commands')
