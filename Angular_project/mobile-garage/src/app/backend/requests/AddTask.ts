import { Location } from "src/app/operator/find-task/find-task.component";

export class AddTask {
    private _name: string;
    private _driverId: number;
    private _vehicleId: number;
    private _location: Location;
    private _isDone: boolean;
    private _reason: string;
    private _images: string[];

    constructor(name: string, vehicleId: number, location: Location, reason: string, images: string[]) {
        name;
        vehicleId;
        location;
        reason;
        images;


    }

    public set name(name: string) {
        this._name = name;
    }

    public get name(): string {
        return this._name
    }
    public set driverId(driverId: number) {
        this._driverId = driverId;
    }

    public get driverId(): number {
        return this._driverId
    }
    public set vehicleId(vehicleId: number) {
        this._vehicleId = vehicleId;
    }

    public get vehicleId(): number {
        return this._vehicleId
    }
    public set location(location: Location) {
        this._location = location;
    }

    public get location(): Location {
        return this._location
    }
    public set isDone(isDone: boolean) {
        this._isDone = isDone;
    }

    public get isDone(): boolean {
        return this._isDone;
    }
    public set reason(reason: string) {
        this._reason = reason;
    }

    public get reason(): string {
        return this._reason;
    }
    public set images(images: string[]) {
        this._images = images;
    }

    public get images(): string[] {
        return this._images;
    }
}