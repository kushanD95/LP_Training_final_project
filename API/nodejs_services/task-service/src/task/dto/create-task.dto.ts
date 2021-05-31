import { Type } from "class-transformer";
import { IsNotEmpty, isUUID, ValidateNested } from "class-validator";


export class Location {
    logtitute: number;
    latitude: number;
}

export class CreateTaskDto {

    id: any;

    @IsNotEmpty()
    driver_id: number;

    @IsNotEmpty()
    vehicle_id: number;

    operator_id: number;

    @IsNotEmpty()
    @Type(() => Location)
    location: Location;

    @IsNotEmpty()
    reason: string;

    @IsNotEmpty()
    is_done: boolean;

    @IsNotEmpty()
    images: string[];


}

