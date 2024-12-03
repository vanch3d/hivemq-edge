import { JSONSchema7 } from 'json-schema'
import { MqttUserProperty } from '@/api/schemas/definitions/MqttUserProperty.json-schema.ts'
import { QoS } from '@/api/schemas/definitions/QoS.json-schema.ts'

/**
 * TODO[NVL] Required as the schema generated by the codegen is of an older version of JSONSchema (v5) and not well structured ($ref missing)
 * @see $NorthboundMappingList
 * @see $NorthboundMapping
 * @see $MqttUserProperty
 * @see $QoS
 */
/* istanbul ignore next -- @preserve */
export const northboundMappingListSchema: JSONSchema7 = {
  definitions: {
    QoS: QoS,
    MqttUserProperty: MqttUserProperty,
    NorthboundMapping: {
      properties: {
        includeTagNames: {
          type: 'boolean',
          title: 'Include Tag Names In Publish?',
          description: 'Include the names of the tags in the resulting MQTT publish',
          default: false,
        },
        includeTimestamp: {
          type: 'boolean',
          title: 'Include Sample Timestamp In Publish?',
          description: 'Include the unix timestamp of the sample time in the resulting MQTT message',
          default: true,
        },
        messageHandlingOptions: {
          type: 'string',
          enum: ['MQTTMessagePerTag', 'MQTTMessagePerSubscription'],
          title: 'Message Handling Options',
          description:
            'This setting defines the format of the resulting MQTT message, either a message per changed tag or a message per subscription that may include multiple data points per sample',
          default: 'MQTTMessagePerTag',
        },
        maxQoS: {
          $ref: '#/definitions/QoS',
        },
        tagName: {
          title: 'Source Tag name',
          type: 'string',
          description: 'The tag for which values should be collected and sent out.',
          format: 'mqtt-tag',
        },
        topic: {
          type: 'string',
          title: 'Destination MQTT Topic',
          description: 'The topic to publish data on',
          format: 'mqtt-topic',
        },
        userProperties: {
          $ref: '#/definitions/MqttUserProperty',
        },
      },
      required: ['topic', 'tagName', 'maxQoS'],
    },
  },
  properties: {
    items: {
      type: 'array',
      items: {
        $ref: '#/definitions/NorthboundMapping',
      },
    },
  },
}
