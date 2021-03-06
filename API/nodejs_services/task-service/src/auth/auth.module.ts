import { Module } from '@nestjs/common';
import { AuthService } from './auth.service';
import { AuthController } from './auth.controller';
import { PassportModule } from '@nestjs/passport';
import { DiscordStrategy } from './discord.strategy';

@Module({
  imports: [
    PassportModule,
  ],
  controllers: [AuthController],
  providers: [
    AuthService,
    DiscordStrategy,
  ]
})
export class AuthModule { }
