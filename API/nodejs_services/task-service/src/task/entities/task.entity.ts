import { Location } from "src/models/location.model";


export interface Task {
    driver_id: number,

    vehicle_id: number,

    operator_id: number,

    location: Location,

    reason: string,

    is_done: boolean,

    images: string[]
}
