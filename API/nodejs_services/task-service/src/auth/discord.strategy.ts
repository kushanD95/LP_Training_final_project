import { PassportStrategy } from '@nestjs/passport';
import { Injectable } from '@nestjs/common';
import { Strategy, VerifyCallback } from 'passport-oauth2';

@Injectable()
export class DiscordStrategy extends PassportStrategy(Strategy)
{
    constructor() {
        super({
            authorizationURL: 'http://localhost:9191/oauth/check_token',
            tokenURL: 'http://localhost:9191/oauth/token',
            clientID: 'mobile',
            clientSecret: 'pin',
        });
    }

    // async validate(accessToken: string, refreshToken: string, profile: any, done: VerifyCallback): Promise<any> {
    //     done(null, accessToken);
    // }
}