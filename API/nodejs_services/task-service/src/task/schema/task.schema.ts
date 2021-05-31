import { Schema } from 'mongoose';
import { LocationSchema } from './location.schema';

export const TaskSchema = new Schema({

    driver_id: {
        type: Number,
        required: true
    },

    vehicle_id: {
        type: Number,
        required: true
    },

    operator_id: {
        type: Number,
        required: true
    },

    location: {
        type: LocationSchema,
        required: true
    },

    reason: {
        type: String,
        required: true
    },

    is_done: {
        type: Boolean,
        required: true
    },

    images: {
        type: [String],
        required: true
    },
})
