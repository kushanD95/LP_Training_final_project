import { Schema } from 'mongoose';

export const LocationSchema = new Schema({
    logtitute: {
        type: Number,
        requred: true
    },
    latitude: {
        type: Number,
        required: true
    },
})